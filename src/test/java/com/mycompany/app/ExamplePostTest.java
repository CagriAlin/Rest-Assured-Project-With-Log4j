package com.mycompany.app;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class ExamplePostTest extends BaseSetup {

    // Api Get method test
    @Test
    public void postRequest() {

        Map<String, String> jsonContentMap = JsonFileManager.getAllJsonContentsByFileName();
        String requestPostBody = jsonContentMap.get("postRequestBody.json");

        Response response = given()
                .header("Content-type", "application/json; charset=utf-8")
                .body(requestPostBody)
                .when()
                .post("/products/add")
                .then()
                .extract()
                .response();

        logger.info("***** Test Started ***** Post Method");

        int statusCode = response.getStatusCode();
        // Check if the status code is 200
        if (statusCode == 200) {
            // Log the status code as successful
            logger.info("Status code is 200: Successful");
            // Get the body of the response as a string
            String actualbody = response.getBody().asString();
            logger.info(actualbody);
            // Get the body of the request as a string
            String expectedBody = jsonContentMap.get("postResponseBody.json");
            expectedBody = expectedBody.replaceAll("(?<!\")\\s*(\\d+)\\s*(?!\")", "$1")
                    .replaceAll("\\s*\"\\s*", "\"");
            logger.info(expectedBody);
            // Check if the body contains the expected data
            if (actualbody.contains(expectedBody)) {
                // Log the body as valid
                logger.info("Body is valid: Contains expected data");
            } else {
                // Log the body as invalid
                logger.error("Body is invalid: Does not contain expected data");
            }
        } else {
            // Log the status code as failed
            logger.error("Status code is not 200: Failed" + statusCode);
        }

        logger.info("***** Test Finished *****");
    }

}