package com.nz.supplieritem.config.web;

import com.nz.supplieritem.filter.CallableInterceptor;
import com.nz.supplieritem.filter.DeferredResultInterceptor;
import com.nz.supplieritem.filter.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@Configuration //这个要打开
public class WebInterceptorConfig extends WebMvcConfigurerAdapter {//原来需要继承 WebMvcConfigurerAdapter 后面就不用了 直接实现WebMvcConfigurer这个接口
    @Autowired
    private TimeInterceptor timeInterceptor;
    @Autowired
    private CallableInterceptor callableInterceptor;
    @Autowired
    private DeferredResultInterceptor deferredResultInterceptor;

    /**
     * 拦截异步回调
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.registerCallableInterceptors();
        configurer.registerDeferredResultInterceptors();
        configurer.setDefaultTimeout(50000);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
