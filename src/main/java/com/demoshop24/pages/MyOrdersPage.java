package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage extends BasePageObject{


    By orderHistory = By.xpath("//*[text()='You have not made any previous orders!']");

    public MyOrdersPage(WebDriver driver, Logger log){
        super(driver,log);
    }

    public boolean isOrderHistoryTextVisible(){
        return find(orderHistory).isDisplayed();
    }

}
