package com.dev.learning.rabbitmq.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropManager {
	private static Properties PROPERTIES;
	private static final String PROP_NAME = "rabbitmq.properties";
	
	private static void _initialize() {
		try(InputStream is = PropManager.class.getClassLoader().getResourceAsStream(PROP_NAME)) {
			PROPERTIES = new Properties();
			PROPERTIES.load(is);
		}
		catch(IOException e) {
			System.out.println("Properties file: [" + PROP_NAME + "] could not be initialized");
		}
	}
	
	public static Optional<Object> get(String key) {
		if(PROPERTIES == null) _initialize();
		return Optional.ofNullable(PROPERTIES.get(key));
	}

}
