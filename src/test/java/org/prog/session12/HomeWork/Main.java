package org.prog.session12.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://allo.ua");

        // ищем товары
        List<WebElement> goods = driver.findElements(By.cssSelector("[class*='product']"));

        System.out.println("Goods found: " + goods.size());


        // первые 3 товара
        for (int i = 0; i < 3; i++) {

            WebElement good = goods.get(i);

            String text = good.getText();

            System.out.println("Product " + (i + 1));
            System.out.println(text);

            // проверка что товар не пустой
            if (text != null) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }

            System.out.println("----------------");
        }


        driver.quit();
    }
}