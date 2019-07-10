package com.pasdam.javatemplate;

import org.slf4j.LoggerFactory;

/**
 * Example application.
 */
public final class Application {

	private Application() {}

	/**
	 * Main method.
	 *
	 * @param args
	 * 			arguments from command line
	 */
	public static void main(String[] args) {
		LoggerFactory.getLogger(Application.class).info("Hello world");
	}
}
