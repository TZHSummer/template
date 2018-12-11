package com.mlj.tshop.backend.controller;

import com.mlj.tshop.backend.util.Validator;
import com.mlj.tshop.backend.vo.ManagerVo;
import com.mlj.tshop.common.exception.ManagerExistException;
import com.mlj.tshop.common.exception.ManagerNotExistException;
import com.mlj.tshop.common.exception.PasswordIncorrectException;
import com.mlj.tshop.pojo.Manager;
import com.mlj.tshop.pojo.Product;
import com.mlj.tshop.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Product> findAll(){
        List<Product> productList = managerServiceImpl.findAll();
        System.out.println(productList);
        return productList;
    }

    @RequestMapping("/findById")
    public String findById(int id){
        Manager manager = null;
        try {
            manager = managerServiceImpl.findById(id);
            return "success";
        } catch (ManagerNotExistException e) {
            e.printStackTrace();
            logger.debug(e);
            return "login";
        }finally {
            System.out.println(manager);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody ManagerVo managerVo, HttpServletRequest request) {
        Map<String, Object> returnedData = new HashMap<>();
        returnedData.put("result", false);
        try {
            Manager manager = managerServiceImpl.login(managerVo.getUsername(), managerVo.getPassword());
            request.getSession().setAttribute("manager", manager);
            returnedData.put("result", true);
            returnedData.put("errorMessage", "登录成功,即将跳往主页面!");
        } catch (ManagerNotExistException e) {
            e.printStackTrace();
            logger.debug(e);
            returnedData.put("errorMessage", "用户不存在!");
        } catch (PasswordIncorrectException e) {
            e.printStackTrace();
            logger.debug(e);
            returnedData.put("errorMessage", "密码错误!");
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
        returnedData.put("result", false);
        returnedData.put("manager", managerVo);

        System.out.println(managerVo);

        Map<String, String> errorMap = Validator.validate(managerVo, errorResult);
        if (null == errorMap){  //数据格式验证通过
            if (managerVo.getPassword().equals(managerVo.getRepassword())){    //密码一致性验证通过
                Manager manager = new Manager();
                manager.setName(managerVo.getUsername());
                manager.setPassword(managerVo.getPassword());
                try {
                    managerServiceImpl.register(manager);
                    returnedData.put("result", true);
                    returnedData.put("errorMessage", "恭喜您注册成功，即将跳转到登录页面");
                } catch (ManagerExistException e) {
                    e.printStackTrace();
                    returnedData.put("errorMessage", "用户名已存在！");
                }finally {
                    return returnedData;
                }
            }else {
                returnedData.put("errorMessage", "密码不一致！");
            }
        }else {
            returnedData.put("errorMap", errorMap);
        }
        return returnedData;
    }
}
