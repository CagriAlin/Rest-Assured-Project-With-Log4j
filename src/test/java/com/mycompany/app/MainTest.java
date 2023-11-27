package com.mycompany.app;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class MainTest extends BaseSetup {

    // Api all method tests
    @Test
    public void mainTest() {
        ExampleGetTest exampleGetTest = new ExampleGetTest();
        exampleGetTest.getRequest();
        ExamplePostTest examplePostTest = new ExamplePostTest();
        examplePostTest.postRequest();
    }
    
}