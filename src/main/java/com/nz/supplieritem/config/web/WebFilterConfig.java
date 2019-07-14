package com.nz.supplieritem.config.web;

import com.nz.supplieritem.filter.TimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 加入第三方拦截器的方法
 * 好处是可以设定拦截指定url
 */
//@Configuration
public class WebFilterConfig {
//    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        frb.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        frb.setUrlPatterns(urls);
        return frb;
    }
}
