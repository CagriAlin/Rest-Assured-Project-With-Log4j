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
            RestAssured.baseURI = "https://dummyjson.com/";

    }
}
