package org.prog.session14.pages;

public class RozetkaMainPage {

    public GoodsSearchPage searchForGoods(String goods){
        //driver.find("search").sendKeys(goods);
        //driver.find("search").sendKeys(Keys.ENTER);
        return new GoodsSearchPage();
    }
}
