package com.nz.supplieritem.filter;

import com.nz.supplieritem.util.httputil.HandlingHttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

//@Component
//如果不适用Component注解如何注入filter
//详情看 WebFilterConfig 类
public class TimeFilter implements Filter {
    /**
     * 处理拦截事务
     * @param req
     * @param rep
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start: " + req.getServletContext().getContextPath());
        String scheme = req.getScheme();
        System.out.println("scheme: " + scheme);

        HttpServletRequest hsr = (HttpServletRequest) req;
        String servletPath = hsr.getServletPath();
        System.out.println("servletPath: " + servletPath);

        String visitIp = HandlingHttpRequest.getVisitIp(hsr);
        System.out.println("访问者ip : " + visitIp);
//        String queryString = hsr.getQueryString();
//        System.out.println("请求参数 ： " + queryString);
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.keySet().stream().forEach(name->{
            String[] s = parameterMap.get(name);
            StringBuilder sb = new StringBuilder();
            for(String n:s){
                sb.append(n);
            }
            System.out.println("name : " + name + " value: " + sb.toString());
        });
//        String realPath = req.getServletContext().getRealPath("/");
//        System.out.println("realPath：" + realPath);
//        long l1 = System.currentTimeMillis();
//        chain.doFilter(req,rep);
//        long l2 = System.currentTimeMillis();
//        System.out.println("执行请求耗时 ： " + (l2-l1));
    }

    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
