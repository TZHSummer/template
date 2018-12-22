package com.mlj.tshop.backend.interceptor;

import com.mlj.tshop.common.constant.ManagerConstant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2018/12/12：后台请求拦截器,拦截未登录请求
 *
 * @author mlj
 */
public class BackendInterceptor implements HandlerInterceptor {
    @Override
    public boolean  preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (null != request.getSession().getAttribute(ManagerConstant.MANAGER)){
            return true;
        }else{
            response.sendRedirect("/");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
