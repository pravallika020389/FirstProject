package com.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingTest {
	public static void login() {
	Logger log = LogManager.getLogger(LoggingTest.class);
	log.info("");
	}
}
