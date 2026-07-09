package org.prog.session14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session14.pages.GooglePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//TODO: Alter existing tests to work with page object
//TODO: Create table in DB "Phones" and store model and price in it

public class WebTest {

//    private RozetkaPage rozetkaPage;
//
//    @Test
//    public void myWebTest() {
//        rozetkaPage.loadPage();
//        rozetkaPage.selectFromCatalog("Побутова техніка", "Плити");
//        rozetkaPage.setGoodsFilter("Бренд", "Beko");
//        rozetkaPage.setGoodsFilter("Бренд", "Hansa");
//        rozetkaPage.setGoodsFilter("Ціна", "20000-40000");
//        rozetkaPage.setGoodsFilter("Додаткові функції ", "Конвекція");
//        List<WebElement> goods = rozetkaPage.getGoods(5);
//        Assert.assertEquals(goods.get(0).getText(), "Духова шафа електрична Hansa BOES69821");
//        Assert.assertEquals(goods.get(1).getText(), "Духова шафа електрична Hansa BOES69821");
//        Assert.assertEquals(goods.get(2).getText(), "Духова шафа електрична Hansa BOES69821");
//        Assert.assertEquals(goods.get(3).getText(), "Духова шафа електрична Hansa BOES69821");
//        Assert.assertEquals(goods.get(4).getText(), "Духова шафа електрична Hansa BOES69821");
//    }
//
//    @Test
//    public void myWebTest2(){
//        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage();
//        GoodsSearchPage gsp = rozetkaMainPage.searchForGoods("iphone");
//        List<GoodsCard> iphones = gsp.getGoods(10);
//        iphones.get(0).getPrice();
//    }

    private WebDriver driver;
    private GooglePage googlePage;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    @Test
    public void googleSearch() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent(true);
        googlePage.setSearchValue("Selenium Demo");
        googlePage.performSearch();
    }

    @Test
    public void googleSearch2() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent(false);
        googlePage.setSearchValue("Selenium Demo");
        googlePage.performSearch();
    }
}
