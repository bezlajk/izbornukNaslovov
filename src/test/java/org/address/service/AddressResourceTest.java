package org.address.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AddressResourceTest {

    @Test
    public void testAddressEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello I'll provide some addresses."));
    }

//    @Test
//    public void testGreetingEndpoint() {
//        String uuid = UUID.randomUUID().toString();
//        given()
//                .pathParam("name", uuid)
//                .when().get("/hello/greeting/{name}")
//                .then()
//                .statusCode(200)
//                .body(is("hello " + uuid));
//    }

}
