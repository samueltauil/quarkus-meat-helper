package com.redhat;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
class MeatHelperTest {

    @Test
    void testBeefRare() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/beef/rare")
            .then()
            .statusCode(200)
            .body(equalTo("Recommended temperature for beef rare: 135°F"));
    }

    @Test
    void testBeefMediumWell() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/beef/medium-well")
            .then()
            .statusCode(200)
            .body(equalTo("Recommended temperature for beef medium-well: 165°F"));
    }

    @Test
    void testChickenBreasts() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/chicken/breasts")
            .then()
            .statusCode(200)
            .body(equalTo("Recommended temperature for chicken breasts: 165°F"));
    }

    @Test
    void testChickenUnknownDoneness() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/chicken/roasted")
            .then()
            .statusCode(200)
            .body(equalTo("Unknown doneness for chicken: roasted"));
    }

    @Test
    void testPorkMedium() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/pork/medium")
            .then()
            .statusCode(200)
            .body(equalTo("Recommended temperature for pork medium: 145°F"));
    }

    @Test
    void testLambMediumRare() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/lamb/medium-rare")
            .then()
            .statusCode(200)
            .body(equalTo("Recommended temperature for lamb medium-rare: 145°F"));
    }

    @Test
    void testDuckWellDone() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/duck/well-done")
            .then()
            .statusCode(200)
            .body(equalTo("Recommended temperature for duck well-done: 170°F"));
    }

    @Test
    void testUnknownMeat() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/fish/medium")
            .then()
            .statusCode(200)
            .body(equalTo("Unknown meat: fish"));
    }

    @Test
    void testUnknownDonenessForBeef() {
        RestAssured.given()
            .accept(ContentType.TEXT)
            .get("/meat/beef/blue")
            .then()
            .statusCode(200)
            .body(equalTo("Unknown doneness for beef: blue"));
    }
}