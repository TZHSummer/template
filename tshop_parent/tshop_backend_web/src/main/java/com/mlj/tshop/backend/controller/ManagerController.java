package com.mlj.tshop.backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlj.tshop.backend.util.Validator;
import com.mlj.tshop.backend.vo.ManagerVo;
import com.mlj.tshop.common.constant.ControllerConstant;
import com.mlj.tshop.common.constant.ManagerConstant;
import com.mlj.tshop.common.constant.PaginationConstant;
import com.mlj.tshop.common.exception.ManagerDisableException;
import com.mlj.tshop.common.exception.ManagerExistException;
import com.mlj.tshop.common.exception.ManagerNotExistException;
import com.mlj.tshop.common.exception.PasswordIncorrectException;
import com.mlj.tshop.pojo.Manager;
import com.mlj.tshop.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2018/12/06：
 *
 * @author mlj
 */
@Controller
@RequestMapping("/backend/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerServiceImpl;

    private static Logger logger = Logger.getLogger(ManagerController.class);

    @RequestMapping(value = "/showManager", method = RequestMethod.POST)
    public String showManager(Integer pageNum, Map map){

        if (ObjectUtils.isEmpty(pageNum)){
            pageNum = PaginationConstant.PAGE_NUM;
        }
        List<Manager> productList = managerServiceImpl.findAll();

        //设置分页
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //将查询出的所有数据进行分页设置，封装成pageInfo对象
        PageInfo<Manager> pageInfo = new PageInfo<>(productList);

        map.put("pageInfo", pageInfo);

        return "backend/manager";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Manager> findAll(){
        List<Manager> productList = managerServiceImpl.findAll();
        System.out.println(productList);
        return productList;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Map<String, Object> findById(int id, HttpServletRequest request){
        Map<String, Object> returnedData = new HashMap<>();
        returnedData.put(ControllerConstant.RESULT, ControllerConstant.RESULT_FAILURE);
        if (null == request.getSession().getAttribute(ManagerConstant.MANAGER)){
            return returnedData;
        }
        Manager manager = null;
        try {
            manager = managerServiceImpl.findById(id);
            manager.setPassword(null);
            returnedData.put(ManagerConstant.MANAGER, manager);
            returnedData.put(ControllerConstant.RESULT, ControllerConstant.RESULT_SUCCESS);
            returnedData.put(ControllerConstant.ERROR_MESSAGE, "查询成功，id为" + id + "的管理员存在!");
        } catch (ManagerNotExistException e) {
            e.printStackTrace();
            logger.debug(e);
            returnedData.put(ControllerConstant.ERROR_MESSAGE, "查询失败，id为\" + id + \"的管理员不存在!");
        }finally {
            return returnedData;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody ManagerVo managerVo, HttpServletRequest request) {
        Map<String, Object> returnedData = new HashMap<>();
        returnedData.put(ControllerConstant.RESULT, ControllerConstant.RESULT_FAILURE);
        try {
            Manager manager = managerServiceImpl.login(managerVo.getUsername(), managerVo.getPassword());
            request.getSession().setAttribute(ManagerConstant.MANAGER, manager);
            returnedData.put(ControllerConstant.RESULT, ControllerConstant.RESULT_SUCCESS);
            returnedData.put(ControllerConstant.ERROR_MESSAGE, "登录成功,即将跳往主页面!");
        } catch (ManagerNotExistException e) {
            e.printStackTrace();
            logger.debug(e);
            returnedData.put(ControllerConstant.ERROR_MESSAGE, "用户不存在!");
        } catch (PasswordIncorrectException e) {
            e.printStackTrace();
            logger.debug(e);
            returnedData.put(ControllerConstant.ERROR_MESSAGE, "密码错误!");
        } catch (ManagerDisableException e){
            e.printStackTrace();
            logger.debug(e);
            returnedData.put(ControllerConstant.ERROR_MESSAGE, "此账号已被禁用，详请联系超级管理员!");
        }finally {
            return returnedData;
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("manager");
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(@RequestBody @Valid ManagerVo managerVo, BindingResult errorResult){
        Map<String, Object> returnedData = new HashMap<>();
        returnedData.put(ControllerConstant.RESULT, ControllerConstant.RESULT_FAILURE);
        returnedData.put(ManagerConstant.MANAGER, managerVo);

        System.out.println(managerVo);

        Map<String, String> errorMap = Validator.validate(managerVo, errorResult);
        if (null == errorMap){  //数据格式验证通过
            if (managerVo.getPassword().equals(managerVo.getRepassword())){    //密码一致性验证通过
                Manager manager = new Manager();
                manager.setName(managerVo.getUsername());
                manager.setPassword(managerVo.getPassword());
                try {
                    managerServiceImpl.register(manager);
                    returnedData.put(ControllerConstant.RESULT, ControllerConstant.RESULT_SUCCESS);
                    returnedData.put(ControllerConstant.ERROR_MESSAGE, "恭喜您注册成功，即将跳转到登录页面");
                } catch (ManagerExistException e) {
                    e.printStackTrace();
                    returnedData.put(ControllerConstant.ERROR_MESSAGE, "用户名已存在！");
                }finally {
                    return returnedData;
                }
            }else {
                returnedData.put(ControllerConstant.ERROR_MESSAGE, "密码不一致！");
            }
        }else {
            returnedData.put("errorMap", errorMap);
        }
        return returnedData;
    }
}
