package com.cydeo.apiTests;

import com.cydeo.utilities.FormulaTestBase;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
public class P16_XMLPath extends FormulaTestBase {


    @Test
    public void xmlPath() {

        Response response = given().
                when().get("/circuits").
                then().statusCode(200)
                .extract().response();

        // response.prettyPrint();


        // Create XML Path
        XmlPath xmlPath = response.xmlPath();

        // get me first circuitName
        String circuitName = xmlPath.getString("MRData.CircuitTable.Circuit[0].CircuitName");
        System.out.println("circuitName = " + circuitName);

        // get me first locality
        String locality = xmlPath.getString("MRData.CircuitTable.Circuit[0].Location.Locality");
        System.out.println("locality = " + locality);

        // get me first country
        String country = xmlPath.getString("MRData.CircuitTable.Circuit[0].Location.Country");
        System.out.println("country = " + country);


        // get me first circuit circuitID
        String circuitID = xmlPath.getString("MRData.CircuitTable.Circuit[0].@circuitId");
        System.out.println("circuitID = " + circuitID);

    }
}
