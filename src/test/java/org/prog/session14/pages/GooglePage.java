package org.prog.session14.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {

    private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://www.google.com/");
    }

    public void acceptCookiesIfPresent(boolean acceptCookies) {
        List<WebElement> cookieLink = driver.findElements(
                By.xpath("//a[contains(@href, 'cookies')]"));
        if (!cookieLink.isEmpty() && cookieLink.get(0).isDisplayed()) {
            List<WebElement> cookieFormButtons =
                    driver.findElements(By.xpath("//a[contains(@href, 'cookies')]/../../../..//button"));
            if (acceptCookies) {
                cookieFormButtons.get(3).click();
            } else {
                cookieFormButtons.get(2).click();
            }
        }
    }

    public void setSearchValue(String value) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(value);
    }

    public void performSearch() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.ENTER);
    }
}
