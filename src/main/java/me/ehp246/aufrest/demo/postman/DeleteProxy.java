package me.ehp246.aufrest.demo.postman;

import org.springframework.web.bind.annotation.RequestParam;

import me.ehp246.aufrest.api.annotation.ByRest;

/**
 * @author Lei Yang
 *
 */
@ByRest("${postman.echo.base}/delete")
public interface DeleteProxy {
	EchoResponseBody delete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName);
}
