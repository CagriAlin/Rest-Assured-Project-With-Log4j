package com.mycompany.app;

import io.restassured.RestAssured;
import org.apache.log4j.*;
import org.junit.jupiter.api.BeforeAll;

public class BaseSetup {
  
  // Log variable 
 public static final Logger logger = Logger.getLogger(BaseSetup.class);

 @BeforeAll
    public static void setup() {
  
  // Base url definition
  RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

  // Configuration for console log
  ConsoleAppender consoleAppender = new ConsoleAppender();
  consoleAppender.setLayout(new SimpleLayout());
  consoleAppender.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss.SSSS} %p %m%n"));
  consoleAppender.activateOptions();

  // Add the appender to the logger
  logger.addAppender(consoleAppender);

  // Configuration for logs.txt file
  FileAppender fileAppender = new FileAppender();
  fileAppender.setLayout(new SimpleLayout());
  fileAppender.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss.SSSS} %p %m%n"));
  fileAppender.setFile("src/test/logs/logs.txt");
  fileAppender.activateOptions();

  // Add the appender to the logger
  logger.addAppender(fileAppender);
 }
}