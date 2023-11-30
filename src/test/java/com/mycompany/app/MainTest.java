package com.mycompany.app;

import org.junit.jupiter.api.Test;

public class MainTest extends BaseSetup {

    // Api all method tests
    @Test
    public void mainTest() {
        // Get Method
        ExampleGetTest exampleGetTest = new ExampleGetTest();
        exampleGetTest.getRequest();
        // Post Method
        ExamplePostTest examplePostTest = new ExamplePostTest();
        examplePostTest.postRequest();
    }
    
}