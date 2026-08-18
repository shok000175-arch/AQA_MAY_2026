package org.prog.session15.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlloPage {

    WebDriver driver;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://allo.ua");
    }

    public void searchPhone(String phone) {

        WebElement search = driver.findElement(By.name("search"));

        search.sendKeys(phone);
        search.submit();
    }

    public String getModel() {

        WebElement product = driver.findElement(By.cssSelector("h1"));

        return product.getText();
    }

    public String getPrice() {

        WebElement price = driver.findElement(By.cssSelector("[class*='price']"));

        return price.getText();
    }
}
