package com.bque.zst1.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.bque.zst1.annotation.NotLogin;

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
		
		
		// 기본 url mapping 핸들러만 적용
		if (handler instanceof HandlerMethod) {
			NotLogin notLogin = ((HandlerMethod) handler).getMethodAnnotation(NotLogin.class);
			
			// 로그인 체크 로직
			if(notLogin == null){
				
			}
		}
		else{
			logger.debug("WebSocketHttpRequestHandler");
		}
		
		logger.debug("	################### preHandle end ");
		
		return true; 
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		
		logger.debug("	################### postHandle start ");
		logger.debug("	################### postHandle end ");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
		
		logger.debug("	################### afterCompletion start ");
		logger.debug("	################### afterCompletion end ");
	}
}
