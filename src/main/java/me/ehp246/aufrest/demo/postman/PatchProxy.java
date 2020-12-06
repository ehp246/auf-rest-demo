package me.ehp246.aufrest.demo.postman;

import org.springframework.web.bind.annotation.RequestParam;

import me.ehp246.aufrest.api.annotation.ByRest;

/**
 * @author Lei Yang
 *
 */
@ByRest("${postman.echo.base}/patch")
public interface PatchProxy {
	EchoResponseBody patch(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName);
}
