package me.ehp246.aufrest.demo.postman;

import me.ehp246.aufrest.api.annotation.ByRest;

/**
 * @author Lei Yang
 *
 */
@ByRest("${postman.echo.base}/post")
public interface PostProxy {
	EchoResponseBody post(NewBorn newBorn);
}
