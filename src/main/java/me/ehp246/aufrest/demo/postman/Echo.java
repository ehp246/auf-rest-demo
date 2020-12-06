package me.ehp246.aufrest.demo.postman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import me.ehp246.aufrest.api.annotation.ByRest;
import me.ehp246.aufrest.api.annotation.OfMapping;

/**
 * @author Lei Yang
 *
 */
@ByRest("${postman.echo.base}")
public interface Echo {
	@OfMapping("/get")
	EchoResponseBody get();

	@OfMapping("/get")
	EchoResponseBody get(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName);

	@OfMapping("/{getPath}")
	EchoResponseBody get(@PathVariable("getPath") String path);

	@OfMapping("/get")
	EchoResponseBody getWithHeaer(@RequestHeader("x-aufrest-demo-request-id") String reqId);
}
