package org.prog.session14.HomeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();


        AlloPage page = new AlloPage(driver);


        page.open();

        page.searchPhone("iPhone");


        driver.quit();
    }
}
