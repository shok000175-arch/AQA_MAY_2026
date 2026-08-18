package org.prog.session15.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlloPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AlloPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }


    public void open() {

        driver.get("https://allo.ua/");

        System.out.println("Current URL: " + driver.getCurrentUrl());

        System.out.println("Page title: " + driver.getTitle());
    }


    public void search(String text) {

        WebElement search = findSearchInput();

        System.out.println("Search field found");

        search.click();

        search.clear();

        search.sendKeys(text);

        System.out.println("Search text entered: " + text);

        search.sendKeys(Keys.ENTER);

        System.out.println("ENTER pressed");

        wait.until(
                ExpectedConditions.urlContains("search")
        );

        System.out.println(
                "Search page opened: " + driver.getCurrentUrl()
        );
    }


    private WebElement findSearchInput() {

        By[] locators = {

                // Вариант 1
                By.cssSelector("input[type='search']"),

                // Вариант 2
                By.cssSelector("input[name='search']"),

                // Вариант 3
                By.cssSelector("input[placeholder*='Пошук']"),

                // Вариант 4
                By.cssSelector("input[placeholder*='пошук']"),

                // Вариант 5
                By.cssSelector("input[placeholder*='Поиск']"),

                // Вариант 6
                By.cssSelector("input[placeholder*='поиск']"),

                // Вариант 7
                By.cssSelector("input[placeholder*='товар']"),

                // Вариант 8
                By.xpath("//input[contains(@placeholder,'Пошук')]"),

                // Вариант 9
                By.xpath("//input[contains(@placeholder,'пошук')]"),

                // Вариант 10
                By.xpath("//input[contains(@placeholder,'Поиск')]"),

                // Вариант 11
                By.xpath("//input[contains(@placeholder,'поиск')]")
        };


        for (By locator : locators) {

            try {

                WebElement element = new WebDriverWait(
                        driver,
                        Duration.ofSeconds(2)
                ).until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                );

                System.out.println(
                        "Search found with locator: " + locator
                );

                return element;

            } catch (Exception ignored) {

                System.out.println(
                        "Locator not found: " + locator
                );
            }
        }


        throw new RuntimeException(
                "Search input was not found on Allo website."
        );
    }


    public List<WebElement> getGoods() {

        By[] locators = {

                By.cssSelector("div.product-card"),

                By.cssSelector("[class*='product-card']"),

                By.cssSelector("[class*='product-card__content']"),

                By.xpath(
                        "//*[contains(@class,'product-card')]"
                )
        };


        for (By locator : locators) {

            try {

                List<WebElement> elements =
                        new WebDriverWait(
                                driver,
                                Duration.ofSeconds(5)
                        ).until(
                                ExpectedConditions
                                        .presenceOfAllElementsLocatedBy(locator)
                        );

                if (!elements.isEmpty()) {

                    System.out.println(
                            "Products found: " + elements.size()
                    );

                    return elements;
                }

            } catch (Exception ignored) {
            }
        }


        throw new RuntimeException(
                "Products were not found."
        );
    }


    public String getModel(WebElement good) {

        By[] locators = {

                By.cssSelector("a.product-card__title"),

                By.cssSelector("[class*='product-card__title']"),

                By.cssSelector("a[class*='title']"),

                By.xpath(
                        ".//a[contains(@class,'title')]"
                )
        };


        for (By locator : locators) {

            try {

                String text = good
                        .findElement(locator)
                        .getText();

                if (!text.trim().isEmpty()) {

                    return text.trim();
                }

            } catch (Exception ignored) {
            }
        }


        return good.getText();
    }


    public String getPrice(WebElement good) {

        By[] locators = {

                By.cssSelector(".v-pb__cur"),

                By.cssSelector("[class*='v-pb__cur']"),

                By.cssSelector("[class*='price']"),

                By.xpath(
                        ".//*[contains(@class,'price')]"
                )
        };


        for (By locator : locators) {

            try {

                String text = good
                        .findElement(locator)
                        .getText();

                if (!text.trim().isEmpty()) {

                    return text.trim();
                }

            } catch (Exception ignored) {
            }
        }


        return "Price not found";
    }
}