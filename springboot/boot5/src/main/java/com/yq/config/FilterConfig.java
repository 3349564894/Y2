package com.yq.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new AuthorizationFilter());
        registrationBean.setName("AuthorizationFilter");
        registrationBean.addUrlPatterns("/main"); //限制main访问
        registrationBean.setOrder(5);
        return registrationBean;
    }
}
