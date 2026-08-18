package org.prog.session15.HomeWork;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class AlloSteps {

    private WebDriver driver;

    private AlloPage alloPage;

    private List<WebElement> goods;


    @Before
    public void startBrowser() {

        System.out.println("========== TEST START ==========");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        alloPage = new AlloPage(driver);

        System.out.println("Browser started");
    }


    @Given("I open Allo website")
    public void openAlloWebsite() {

        alloPage.open();

        System.out.println("Allo opened");
    }


    @When("I search for iPhone")
    public void searchForIphone() {

        alloPage.search("iPhone");

        goods = alloPage.getGoods();

        System.out.println(
                "Amount of goods found: " + goods.size()
        );

        assertTrue(
                goods.size() >= 3,
                "Less than 3 goods found!"
        );
    }


    @Then("I check first {int} goods")
    public void checkFirstGoods(Integer count) {

        assertTrue(
                goods != null,
                "Goods list is null!"
        );

        assertTrue(
                goods.size() >= count,
                "Not enough goods found!"
        );


        for (int i = 0; i < count; i++) {

            WebElement good = goods.get(i);

            String model = alloPage.getModel(good);

            String price = alloPage.getPrice(good);


            System.out.println();
            System.out.println("----------------------------");

            System.out.println(
                    "Good number: " + (i + 1)
            );

            System.out.println(
                    "Model: " + model
            );

            System.out.println(
                    "Price: " + price
            );


            assertTrue(
                    model != null &&
                            !model.trim().isEmpty(),
                    "Model is empty!"
            );


            assertTrue(
                    price != null &&
                            !price.trim().isEmpty(),
                    "Price is empty!"
            );
        }


        System.out.println("----------------------------");

        System.out.println(
                "First " + count +
                        " goods checked successfully!"
        );
    }


    @After
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();

            System.out.println("Browser closed");
        }

        System.out.println("=========== TEST END ===========");
    }
}
