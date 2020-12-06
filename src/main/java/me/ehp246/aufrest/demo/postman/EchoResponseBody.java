package me.ehp246.aufrest.demo.postman;

import java.util.Map;

public interface EchoResponseBody {
	Map<String, String> getArgs();

	Map<String, String> getHeaders();

	String getUrl();

	Map<String, Object> getData();

	Map<String, Object> getJson();
}