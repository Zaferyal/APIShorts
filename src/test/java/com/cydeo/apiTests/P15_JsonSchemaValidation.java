package com.cydeo.apiTests;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P15_JsonSchemaValidation extends SpartanTestBase {


    @Test
    public void singleSpartanJsonSchema() {

        Response response = given().accept(ContentType.JSON).
                pathParam("id", 5).
                when().get("/api/spartans/{id}").
                then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"))
                .extract().response();

        response.prettyPrint();

    }
}
