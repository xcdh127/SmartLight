package com.light.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/buttons");
//        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/default");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/toWeiZhi");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/xinxi");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/toDianLiang");
        super.addInterceptors(registry);
    }
}
