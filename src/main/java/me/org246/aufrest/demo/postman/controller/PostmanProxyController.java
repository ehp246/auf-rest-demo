package me.org246.aufrest.demo.postman.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.org246.aufrest.demo.postman.AuthProxy;
import me.org246.aufrest.demo.postman.EchoResponseBody;
import me.org246.aufrest.demo.postman.GetProxy;

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

	@GetMapping(path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EchoResponseBody get() {
		return get.getAsEchoBody();
	}

	@GetMapping(path = "auth", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> authSuccess() {
		return auth.get();
	}
}
