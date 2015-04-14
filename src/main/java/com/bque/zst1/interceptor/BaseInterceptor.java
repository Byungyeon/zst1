package com.bque.zst1.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

public class BaseInterceptor extends WebContentInterceptor {
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {
		// TODO Auto-generated method stub
		
		super.preHandle(request, response, handler);
		
		logger.debug("	################### preHandle start ");
		logger.debug("	################### preHandle end ");
		
		return true; 
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		
		logger.debug("	################### preHandle start ");
		logger.debug("	################### preHandle end ");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
		
		logger.debug("	################### preHandle start ");
		logger.debug("	################### preHandle end ");
	}
}
