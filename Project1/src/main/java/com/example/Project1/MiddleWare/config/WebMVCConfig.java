package com.example.Project1.MiddleWare.config;

import com.example.Project1.MiddleWare.Interceptor.BoardInterceptor;
import com.example.Project1.MiddleWare.Interceptor.GlobalInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.checkerframework.checker.units.qual.A;
// import org.checkerframework.checker.units.qual.g;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    private BoardInterceptor boardInterceptor;
    
    @Autowired
    private GlobalInterceptor globalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        registry.addInterceptor(globalInterceptor)
            .order(1)
            .addPathPatterns("/api/**")
            .excludePathPatterns("/api/board/**");
         
        
        registry.addInterceptor(boardInterceptor)   //interceptor 등록
            .order(2)   //우선도
            .addPathPatterns("/api/board/**"); //사용될 url
            //.excludePathPatterns()    //제외될 url
    }
}