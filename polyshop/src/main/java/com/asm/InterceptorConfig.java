package com.asm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.asm.interceptors.AdminInterceptor;
import com.asm.interceptors.AuthenticateInterceptor;
import com.asm.interceptors.LogInterceptor;
import com.asm.interceptors.ShareInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	AuthenticateInterceptor authInterceptor;
	
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Autowired
	LogInterceptor logInterceptor;
	
	@Autowired
	ShareInterceptor ShareInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(logInterceptor)
			.addPathPatterns("/**");

		registry.addInterceptor(authInterceptor)
			.addPathPatterns("/admin/**","/user/history","/item/shoppingCart/save","/user/acc/infor")
			.excludePathPatterns("/login");

		registry.addInterceptor(adminInterceptor)
			.addPathPatterns("/admin/**")
			.excludePathPatterns("/hello");
		registry.addInterceptor(ShareInterceptor)
			.addPathPatterns("/**");
			
	}
}
