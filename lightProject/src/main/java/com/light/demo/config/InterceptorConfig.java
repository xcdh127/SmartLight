package com.light.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/buttons");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/default");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/location");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/xinxi");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/dianliang");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/gongdan/**");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/light/**");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/toXinXi");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/toDianLiang");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/tolocation");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/toone");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/togongdan");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/toedit");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/todelete");
        super.addInterceptors(registry);
    }
}
