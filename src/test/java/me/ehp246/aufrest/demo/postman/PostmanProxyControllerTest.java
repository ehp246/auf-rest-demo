package me.ehp246.aufrest.demo.postman;

import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.ehp246.aufrest.demo.postman.controller.PostmanProxyController;

/**
 * @author Lei Yang
 *
 */
@SpringBootTest(classes = PostmanApplication.class)
class PostmanProxyControllerTest {
	@Autowired
	private PostmanProxyController postmanController;

	@Test
	void get_001() {
		final var get = postmanController.get();

		Assertions.assertEquals(true, get.getArgs() != null);
	}

	@Test
	void post_001() {
		final var dob = Instant.now();

		final var post = postmanController.post(dob);

		Assertions.assertEquals(true, Instant.parse(post.getJson().get("dob").toString()).equals(dob));
	}

	@Test
	void put_001() {
		final var put = postmanController.put("Jon");

		Assertions.assertEquals("Jon", put.getArgs().get("firstName"));
	}

	@Test
	void patch_001() {
		final var put = postmanController.patch("Jon", "Snow");

		Assertions.assertEquals("Jon", put.getArgs().get("firstName"));
	}

	@Test
	void delete_001() {
		final var delete = postmanController.delete("Jon", "Snow");

		Assertions.assertEquals("Jon", delete.getArgs().get("firstName"));
	}
}
