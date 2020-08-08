package me.org246.aufrest.demo.postman;

import java.util.Map;

public interface EchoResponseBody {
	Map<String, String> getArgs();

	Map<String, String> getHeaders();

	String getUrl();

	String getData();

	String getJson();
}