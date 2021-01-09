package com.demo01.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Soap
 * time 2021-01-06 4:19
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (request.getSession().getAttribute("admin") == null) {
            System.out.println(request.getRequestURI() + " 请求被拦截，原因：未登录。");
//            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
