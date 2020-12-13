package me.ehp246.aufrest.demo.postman;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import me.ehp246.aufrest.demo.postman.HeaderContextInterceptor;

/**
 * @author Lei Yang
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(new HeaderContextInterceptor());
	}

}
