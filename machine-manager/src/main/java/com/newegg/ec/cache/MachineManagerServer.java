package com.newegg.ec.cache;

import com.newegg.ec.base.EnableWebBase;
import com.newegg.ec.base.filter.AuthenticationFIlter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.servlet.Filter;

/**
 * Created by jn50 on 2018/3/14.
 */
@EnableAutoConfiguration
@EnableWebBase
@EnableMachineManager
@EnableTransactionManagement
public class MachineManagerServer {

    public static void main(String[] args) {
        SpringApplication.run(MachineManagerServer.class, args);
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authenticationFilter());
        registration.addUrlPatterns("/rest");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        return registration;
    }

    @Bean(name = "sessionFilter")
    public Filter authenticationFilter() {
        return new AuthenticationFIlter();
    }

}
