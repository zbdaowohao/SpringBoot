package com.ads.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 多个拦截器按顺序执行
		 */
		registry.addInterceptor(new Interceptor()).addPathPatterns("/filter");
		//registry.addInterceptor(new aontherInterceptor()).addPathPatterns("/home").addPathPatterns("/index");  
		super.addInterceptors(registry);
	}

}
