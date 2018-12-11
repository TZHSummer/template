package com.mlj.tshop.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 2018/12/05：后台总Controller
 *
 * @author mlj
 */
@Controller
@RequestMapping("/backend")
public class BackendController {

    @RequestMapping("/main")
    public String main(HttpServletRequest request){
        if (null == request.getSession().getAttribute("manager")){
            return "login";
        }else {
            return "backend/main";
        }
    }
}
