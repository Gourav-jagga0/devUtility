package com.dev.utility.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	@Autowired
	LoggingFilter loggingFilter;
	@Bean
	FilterRegistrationBean<LoggingFilter> logginFilter(){
		FilterRegistrationBean<LoggingFilter> fltr=new FilterRegistrationBean<>();
		fltr.addUrlPatterns("/*");
		fltr.setFilter(loggingFilter);
		fltr.setOrder(1);
		return fltr;
		}
}
