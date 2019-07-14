package com.nz.supplieritem.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 还需要 WebInterceptorConfig这个类
 */
//@Component //这个要放开
public class TimeInterceptor implements HandlerInterceptor {
    /**
     * controller 方法调用之前调用
     * @param req
     * @param res
     * @param handler
     * @return
     * @throws Exception
     */
    @Override

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        System.out.println("进入拦截器 。。。 ");
        return true;
    }

    /**
     * 执行拦截事务
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * controller 方法调用之后调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
