package com.cydeo.apiTests;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P17_ValueSource extends SpartanTestBase {


    @ParameterizedTest
    @ValueSource(strings = {"Muhtar","Saim","Gurhan","Aysun","George","Austin","Adam"})
    public void test1(String name){


        System.out.println(name);
        Assertions.assertTrue(name.length()>5);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9,12,15})
    public void test2(int spartanID){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", spartanID).
                when().get("/api/spartans/{id}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertEquals(spartanID,jsonPath.getInt("id"));


    }

}
