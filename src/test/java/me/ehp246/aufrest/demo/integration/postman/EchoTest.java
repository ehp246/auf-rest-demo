package me.ehp246.aufrest.demo.integration.postman;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import me.ehp246.aufrest.api.exception.UnhandledResponseException;
import me.ehp246.aufrest.api.rest.HeaderContext;
import me.ehp246.aufrest.demo.postman.Echo;
import me.ehp246.aufrest.demo.postman.PostmanApplication;

@SpringBootTest(classes = PostmanApplication.class)
class EchoTest {
	@Autowired
	private ApplicationContext context;

	@BeforeEach
	void clear() {
		HeaderContext.clear();
	}

	@Test
	void get_001() {
		final var bean = context.getBean(Echo.class);

		final var body = bean.get("Jon", "Snow");

		Assertions.assertEquals("Jon", body.getArgs().get("firstName"));
	}

	@Test
	void get_002() {
		final var bean = context.getBean(Echo.class);

		final var body = bean.get("get");

		Assertions.assertEquals("https://postman-echo.com/get", body.getUrl());

		final var exception = Assertions.assertThrows(UnhandledResponseException.class, () -> bean.get("wrong"));

		Assertions.assertEquals(404, exception.statusCode());
	}

	@Test
	void header_req() {
		final var bean = context.getBean(Echo.class);
		final var value = UUID.randomUUID().toString();

		final var body = bean.getWithHeaer(value);

		Assertions.assertEquals(value, body.getHeaders().get("x-aufrest-demo-request-id"));
	}

	@Test
	void header_context() {
		final var bean = context.getBean(Echo.class);
		final var value = UUID.randomUUID().toString();

		HeaderContext.add("x-aufrest-demo-request-id", value);

		final var body = bean.get();

		Assertions.assertEquals(value, body.getHeaders().get("x-aufrest-demo-request-id"));
	}

	@Test
	void header_provider() {
		final var bean = context.getBean(Echo.class);
		final var value = UUID.randomUUID().toString();

		HeaderContext.add("x-aufrest-demo-request-id", value);

		final var body = bean.get();

		Assertions.assertEquals(value, body.getHeaders().get("x-aufrest-demo-request-id"));
	}
}
