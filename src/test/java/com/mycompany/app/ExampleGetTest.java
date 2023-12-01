package com.mycompany.app;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExampleGetTest extends BaseSetup {

    Map<String, String> jsonContentMap = JsonFileManager.getAllJsonContentsByFileName();

    // Api Post method test
    @Test
    public void getRequest() {

        Response response = given()
                .header("Content-type", "application/json; charset=utf-8")
                .when()
                .get("/products/1")
                .then()
                .extract()
                .response();

        logger.info("***** Test Started ***** Get Method");

        int statusCode = response.getStatusCode();
        // Check if the status code is 200
        if (statusCode == 200) {
            // Log the status code as successful
            logger.info("Status code is 200: Successful");
            // Get the body of the response as a string
            String actualbody = response.getBody().asString();
            logger.info(actualbody);
            // Get the body of the expected as a string
            String expectedBody = jsonContentMap.get("getResponseBody.json");
            expectedBody = expectedBody.replaceAll("(?<!\")\\s*(\\d+)\\s*(?!\")", "$1")
                    .replaceAll("\\s*\"\\s*", "\"")
                    .replaceAll("\\s*\\[\\s*", "[").replaceAll("\\s*\\]\\s*", "]");
            logger.info(expectedBody);
            // Check if the body contains the expected data
            if (actualbody.equals(expectedBody)) {
                // Log the body as valid
                logger.info("Body is valid: Contains expected data");
            } else {
                // Log the body as invalid
                logger.error("Body is invalid: Does not contain expected data");
            }
            long responseTime = response.getTime();
            // Log the response time
            logger.info("Response time: " + responseTime + " ms");
            // Compare the response time with 500 milliseconds
            if (responseTime > 500) {
                // Log the response time as slow
                logger.warn("Response time is greater than 500 ms: Slow");
            } else {
                // Log the response time as normal
                logger.info("Response time is less than or equal to 500 ms: Normal");
            }

        } else {
            // Log the status code as failed
            logger.error("Status code is not 200: Failed" + statusCode);
        }

        logger.info("***** Test Finished *****");

    }

}