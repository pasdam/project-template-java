package com.pasdam.javatemplate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private static final PrintStream originalOut = System.out;
	private static final PrintStream originalErr = System.err;

	@BeforeAll
	public static void setUp() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@AfterAll
	public static void tearDown() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	void main() {
		Application.main(null);

		assertEquals("Hello world\n", outContent.toString());
	}
}
