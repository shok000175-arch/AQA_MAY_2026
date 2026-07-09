package org.prog.session13.HomeWork;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Main {

    public static void main(String[] args) {

        Response response = RestAssured
                .given()
                .when()
                .get("https://randomuser.me/api/?results=5");

        System.out.println(response.asString());


        for (int i = 0; i < 5; i++) {

            String city = response.jsonPath()
                    .getString("results[" + i + "].location.city");

            String street = response.jsonPath()
                    .getString("results[" + i + "].location.street.name");


            System.out.println("Person " + (i + 1));
            System.out.println("City: " + city);
            System.out.println("Street: " + street);


            if (city != null && street != null) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }

            System.out.println("----------------");
        }
    }
}
