package com.mlj.tshop.backend.controller;

import com.mlj.tshop.common.exception.ManagerNotFindException;
import com.mlj.tshop.pojo.Manager;
import com.mlj.tshop.pojo.Product;
import com.mlj.tshop.service.ManagerService;
import com.mlj.tshop.service.impl.ManagerServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("findAll")
    @ResponseBody
    public List<Product> findAll(){
        List<Product> productList = managerServiceImpl.findAll();
        System.out.println(productList);
        return productList;
    }

    @RequestMapping("findById")
    @ResponseBody
    public Manager findById(int id){
        System.out.println(id);
        Manager manager = null;
        try {
            manager = managerServiceImpl.findById(id);
        } catch (ManagerNotFindException e) {
            e.printStackTrace();
        }
        System.out.println(manager);
        return manager;
    }

}
