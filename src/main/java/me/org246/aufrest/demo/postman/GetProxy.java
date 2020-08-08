package me.org246.aufrest.demo.postman;

import me.ehp246.aufrest.api.annotation.ByRest;

/**
 * @author Lei Yang
 *
 */
@ByRest("${postman.echo.base}/get")
public interface GetProxy {
	EchoResponseBody getAsEchoBody();
}
