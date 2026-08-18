package org.prog.session15.HomeWork;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlloSteps {

    WebDriver driver;
    AlloPage alloPage;

    String model;
    String price;


    @Given("I open Allo website")
    public void openAllo() {

        driver = new ChromeDriver();

        alloPage = new AlloPage(driver);

        alloPage.open();
    }


    @When("I search for iPhone")
    public void searchIphone() {

        alloPage.searchPhone("iPhone");
    }


    @Then("I get phone model and price")
    public void getPhone() {

        model = alloPage.getModel();
        price = alloPage.getPrice();

        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }


    @Then("I save phone to database")
    public void savePhone() {

        Database.savePhone(model, price);

        driver.quit();
    }
}
