package com.bque.zst1.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 스프링의 빈을 획득하기위한 클래스
 */
public class SpringBeanHelper {

	 /**
     * 빈을 획득
     *
     * @param request the request
     * @param beanId the bean id
     * @return the bean
     * @throws Exception the exception
     */
    public static Object getBean(final HttpServletRequest request, final String beanId) throws Exception {
        Object beanObject = null;
        ServletContext sc;
        HttpSession hs;
        WebApplicationContext webApplicationContext;

        // DispatcherServlet으로 로딩된 context를 가져 온다.
        webApplicationContext = RequestContextUtils.getWebApplicationContext(request);
        // 빈을 검색해서 해당 빈 오브젝트를 가져 온다.
        if (webApplicationContext.containsBean(beanId)) {
            beanObject = webApplicationContext.getBean(beanId);
            return beanObject;
        }

        hs = request.getSession();
        sc = hs.getServletContext();
        // ContextLoaderListener으로 로딩된 context를 가져 온다.
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);

        if (webApplicationContext.containsBean(beanId)) {
            beanObject = webApplicationContext.getBean(beanId);
            return beanObject;
        }
        
        return beanObject;
    }

}
