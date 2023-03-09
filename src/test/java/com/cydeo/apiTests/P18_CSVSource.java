package com.cydeo.apiTests;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class P18_CSVSource extends SpartanTestBase {


        @ParameterizedTest
        @CsvSource({"Mike,Male,1231231231",
                    "John,Male,1234123412",
                   "Steven,Male,1234512345"
        })
        public void test1(String name,String gender,long phone){

            Map<String,Object> spartanMap=new LinkedHashMap<>();
            spartanMap.put("name",name);
            spartanMap.put("gender",gender);
            spartanMap.put("phone",phone);


            JsonPath jsonPath = given().log().body().accept(ContentType.JSON) // API I need response in json
                    .contentType(ContentType.JSON) // API I am sending data in json
                    .body(spartanMap). // serialization --> JAVA(Collections/POJO) to JSON
                            when().post("/api/spartans").
                    then()
                    .statusCode(201)
                    .contentType("application/json")
                    .extract().jsonPath();


            Assertions.assertEquals(name,jsonPath.getString("data.name"));

        }





}
