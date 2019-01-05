package com.mlj.tshop.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 2018/12/15：
 *
 * @author mlj
 */
@Controller
@RequestMapping("/backend/product")
public class ProductController {

    @RequestMapping(value = "/showProduct", method = RequestMethod.POST)
    public String showProduct(){
        return "backend/product";
    }
}
