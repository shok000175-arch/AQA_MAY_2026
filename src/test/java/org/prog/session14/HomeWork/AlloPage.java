package org.prog.session14.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlloPage {

    WebDriver driver;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }


    By search = By.name("search");


    public void open() {
        driver.get("https://allo.ua");
    }


    public void searchPhone(String phone) {
        driver.findElement(search).sendKeys(phone);
        driver.findElement(search).submit();
    }
}
