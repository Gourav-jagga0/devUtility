package com.dev.utility.filters;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class LoggingFilter  implements Filter {
	org.slf4j.Logger log=LoggerFactory.getLogger(LoggingFilter.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest)request;
		log.debug("logging request "+req.getRequestURI());
		chain.doFilter(request, response);
	}

}
