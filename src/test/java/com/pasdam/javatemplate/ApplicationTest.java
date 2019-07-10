package com.pasdam.javatemplate;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ApplicationTest {

	@Mock
	private Appender appender;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		when(appender.getName()).thenReturn("mock-appender");
		when(appender.isStarted()).thenReturn(true);

		LoggerContext context = LoggerContext.getContext(false);
		Logger logger = context.getLogger(Application.class.getName());
		logger.addAppender(appender);
		logger.setLevel(Level.DEBUG);
	}

	@Test
	void main() {
		Application.main(null);

		ArgumentCaptor<LogEvent> argumentCaptor = ArgumentCaptor.forClass(LogEvent.class);
		verify(appender, times(1)).append(argumentCaptor.capture());
		verify(appender, times(1)).append(any());

		assertEquals("Hello world", argumentCaptor.getValue().getMessage().getFormattedMessage());
	}
}
