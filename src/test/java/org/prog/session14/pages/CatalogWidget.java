package org.prog.session14.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CatalogWidget {

    private WebDriver driver;

    public void selectFromCatalog(String category, String subCategory) {
        WebElement catalog = driver.findElement(By.xpath("//*[@data-testid='fat_menu_btn']"));
        catalog.click();
        WebElement categoryElement = driver.findElement(By.partialLinkText(category));
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryElement).perform();
        WebElement subCategoryElement = driver.findElement(By.partialLinkText(subCategory));
        subCategoryElement.click();
    }
}
