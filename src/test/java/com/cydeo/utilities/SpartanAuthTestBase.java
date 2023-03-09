package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanAuthTestBase {


    @BeforeAll
    public static void init(){

        baseURI= "http://54.237.189.109:7000";
    }
}
