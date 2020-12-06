package me.ehp246.aufrest.demo.postman.controller;

import java.time.Instant;
import java.util.Map;

import me.ehp246.aufrest.demo.postman.AuthProxy;
import me.ehp246.aufrest.demo.postman.DeleteProxy;
import me.ehp246.aufrest.demo.postman.EchoResponseBody;
import me.ehp246.aufrest.demo.postman.GetProxy;
import me.ehp246.aufrest.demo.postman.NewBorn;
import me.ehp246.aufrest.demo.postman.PatchProxy;
import me.ehp246.aufrest.demo.postman.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.ehp246.aufrest.demo.postman.PutProxy;

/**
 * @author Lei Yang
 *
 */
@RestController
public class PostmanProxyController {
	@Autowired
	GetProxy get;

	@Autowired
	AuthProxy auth;

	@Autowired
	PostProxy post;

	@Autowired
	PutProxy put;

	@Autowired
	PatchProxy patch;
	@Autowired
	DeleteProxy delete;

	@GetMapping(path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EchoResponseBody get() {
		return get.get();
	}

	@GetMapping(path = "auth", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> authSuccess() {
		return auth.get();
	}

	@PostMapping(path = "post", produces = MediaType.APPLICATION_JSON_VALUE)
	public EchoResponseBody post(@RequestBody final Instant dob) {
		return post.post(new NewBorn() {

			@Override
			public String getLastName() {
				return "Jon";
			}

			@Override
			public String getFirstName() {
				return "Snow";
			}

			@Override
			public Instant getDob() {
				return dob;
			}
		});
	}

	@PutMapping(path = "put", produces = MediaType.APPLICATION_JSON_VALUE)
	public EchoResponseBody put(final String firstName) {
		return put.put(firstName, "Snow", new NewBorn() {

			@Override
			public String getLastName() {
				return null;
			}

			@Override
			public String getFirstName() {
				return null;
			}

			@Override
			public Instant getDob() {
				return Instant.now();
			}
		});
	}

	@PatchMapping(path = "patch", produces = MediaType.APPLICATION_JSON_VALUE)
	public EchoResponseBody patch(final String firstName, final String lastName) {
		return patch.patch(firstName, lastName);
	}

	@DeleteMapping(path = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public EchoResponseBody delete(final String firstName, final String lastName) {
		return delete.delete(firstName, lastName);
	}
}
