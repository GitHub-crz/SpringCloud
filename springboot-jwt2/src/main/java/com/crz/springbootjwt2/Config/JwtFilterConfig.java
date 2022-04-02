package com.crz.springbootjwt2.Config;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/4/2 15:16
 */

import com.crz.springbootjwt2.Filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


public class JwtFilterConfig{
    @Bean
    public FilterRegistrationBean JwtFilterCpnfig() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        //添加需要拦截的url
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/article/insert");
        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));
        return registrationBean;
    }
}

