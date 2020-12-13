package me.ehp246.aufrest.demo.postman;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import me.ehp246.aufrest.api.rest.HeaderContext;

/**
 * @author Lei Yang
 *
 */
public class HeaderContextInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		HeaderContext.set("x-aufrest-demo-request-id", request.getHeader("x-aufrest-demo-request-id"));
		return true;
	}

}
