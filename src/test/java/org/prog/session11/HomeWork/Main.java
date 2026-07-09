package org.prog.session11.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://allo.ua");

        WebElement search = driver.findElement(By.name("search"));

        search.sendKeys("iPhone");

        search.submit();

        //driver.quit();
    }
}
