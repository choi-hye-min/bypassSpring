package com.example.demo.config;

import com.example.demo.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(testFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

    public Filter testFilter(){
        return new TestFilter();
    }
}
