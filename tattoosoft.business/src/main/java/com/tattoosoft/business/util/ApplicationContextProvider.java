package com.tattoosoft.business.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * A singleton that provides a handle to the Spring application context from anywhere within the
 * application. It implements ApplicationContextAware which makes Spring give it a handle
 * to the application context when the bean is created. It stores a reference to it and exposes it
 * through a static method
 * @author mlara
 *
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	/* Handle to application context instance */
	private static ApplicationContext ctx;

	/**
	 * Spring callback to set the application context
	 */
	@SuppressWarnings("static-access")
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	/**
	 * get the application context
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	public static <T> T getBean(String beanName) throws BeansException {
	    return (T)ApplicationContextProvider.getApplicationContext().getBean(beanName);
	}
}
