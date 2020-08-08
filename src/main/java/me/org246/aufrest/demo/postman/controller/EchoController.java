package me.org246.aufrest.demo.postman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.org246.aufrest.demo.postman.EchoGetProxy;
import me.org246.aufrest.demo.postman.EchoResponseBody;

/**
 * @author Lei Yang
 *
 */
@RestController
public class EchoController {
	@Autowired
	EchoGetProxy get;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public EchoResponseBody get() {
		return get.getAsEchoBody();
	}
}
