package org.prog.session13;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.prog.session13.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

//TODO: Add location to request, assert city name and street name not not for all persons;
// https://randomuser.me/documentation

public class RestTests {

    @Test
    public void restTest() {
//        https://randomuser.me/api?noinfo&inc=gender,name,nat&results=3
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat");
        requestSpecification.queryParam("results", 10);
        Response response = requestSpecification.get();
        List<String> genders = response.jsonPath().getList("results.gender");
        Assert.assertTrue(genders.contains("female"));

        ResultsDto dto = response.as(ResultsDto.class);
        List<String> firstLastNames = dto.getResults().stream()
                .filter(p -> p.getGender().equals("male"))
                .map(p -> p.getName().getFirst() + " " + p.getName().getLast())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(firstLastNames);

        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("results.gender", Matchers.hasItem("female"));
        validatableResponse.body("results.name.title", Matchers.hasItem("Ms"));
    }

    @Test
    public void restTest1() {
        RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", 10)
                .get()
                .then()
                .statusCode(200)
                .body("results.gender", Matchers.hasItem("female"))
                .body("results.name.title", Matchers.hasItem("Ms"));
    }

//    @Test
//    public void joiningDemo() {
//        List<String> strings = new ArrayList<>();
//        strings.add("hello");
//        strings.add("world");
//        strings.add("hello");
//        strings.add("world");
//        strings.add("hello");
//        strings.add("world");
//
//        Optional<String> optionalS1 = Optional.of("str");
//        Optional<String> optionalS2 = Optional.ofNullable("str");
//        Optional<String> optionalS3 = Optional.ofNullable(null);
//        System.out.println(optionalS2.isPresent());
//        System.out.println(optionalS3.isPresent());
//        System.out.println(optionalS3.orElse("default !!!"));
//    }

//    public void generatePerson() {
//        ResultsDto dto = ResultsDto.builder()
//                .results(List.of(
//                        PersonDto.builder()
//                                .gender("female")
//                                .nat("DE")
//                                .name(
//                                        NameDto.builder()
//                                                .title("Ms")
//                                                .first("Test")
//                                                .last("Test")
//                                                .build()
//                                ).build()
//                )).build();
//        System.out.println("results: " + dto.results);
//    }
}
