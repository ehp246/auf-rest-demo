package me.ehp246.aufrest.demo.postman;

import java.util.concurrent.atomic.AtomicReference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.mrbean.MrBeanModule;

import me.ehp246.aufrest.api.annotation.EnableByRest;
import me.ehp246.aufrest.api.rest.AuthorizationProvider;
import me.ehp246.aufrest.api.rest.HeaderProvider;
import me.ehp246.aufrest.api.rest.HttpUtils;

/**
 * @author Lei Yang
 *
 */
@SpringBootApplication
@EnableByRest
public class PostmanApplication {
	public static void main(final String[] args) {
		SpringApplication.run(PostmanApplication.class, args);
	}

	@Bean
	public AuthorizationProvider authProvider() {
		final var countRef = new AtomicReference<Integer>(0);
		return uri -> {
			// Only allow one call.
			if (uri.contains("basic-auth") && countRef.get() == 0) {
				countRef.getAndUpdate(i -> i + 1);
				return HttpUtils.basicAuth("postman", "password");
			}
			return null;
		};
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.registerModule(new MrBeanModule());
	}

	@Bean
	public HeaderProvider headerProvider() {
		return uri -> null;
	}
}
