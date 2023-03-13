package com.happy.javautil.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author happy
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private MyHandlerMethodArgumentResolver myHandlerMethodArgumentResolver;

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(myHandlerMethodArgumentResolver);
    }
}
