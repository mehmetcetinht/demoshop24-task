package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePageObject{

    public CartPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    By cartTotalPrize = By.xpath("(//*[@class='text-right'])[last()]");

    public String getTotalPrizeInCart() {
        return find(cartTotalPrize).getText();
    }

}
