package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject extends BasePageObject{


    private String pageURL="http://www.demoshop24.com/";

    By myAccountButton = By.xpath("//*[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']");
    By myAccountRegisterButton = By.xpath("//*[text()='Register']");
    By searchEditTextArea = By.name("search");
    By searchButton = By.xpath("//*[@class='btn btn-default btn-lg']");

    public HomePageObject(WebDriver driver, Logger log){
        super(driver,log);
    }

    //Opens home page
    public void openPage(){

        log.info("Opening page: "+ pageURL);
        openUrl(pageURL);
        log.info("Page opened!");
    }


    public RegisterPage openRegisterPage(){
        log.info("Opening Register page");
        click(myAccountButton);
        click(myAccountRegisterButton);
        return new RegisterPage(driver,log);
    }

    public DesktopPage openDesktopPage(){
        log.info("Opening Desktop page");
        WebElement desktopsDropdown = driver.findElement(By.xpath("//*[@class='dropdown-toggle' and contains(text(),'Desktops')]"));
        mouseOver(desktopsDropdown);
        By macElement = By.xpath("//*[contains(text(),'Mac (')]");
        click(macElement);
        return new DesktopPage(driver,log);
    }

    public SearchedProductsPage openSearchedProductsPage(){
        log.info("Opening Searched Products page");
        type("Samsung SyncMaster 941BW",searchEditTextArea);
        click(searchButton);
        return new SearchedProductsPage(driver,log);
    }

}
