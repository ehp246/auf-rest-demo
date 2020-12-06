package me.ehp246.aufrest.demo.postman;

import java.util.Map;

import me.ehp246.aufrest.api.annotation.ByRest;
import me.ehp246.aufrest.api.annotation.ByRest.Auth;
import me.ehp246.aufrest.api.annotation.ByRest.Auth.Type;

/**
 * @author Lei Yang
 *
 */
@ByRest(value = "${postman.echo.base}/basic-auth", auth = @Auth(value = "${postman.echo.username}:${postman.echo.password}", type = Type.BASIC))
public interface AuthProxy {
	Map<String, Boolean> get();
}
