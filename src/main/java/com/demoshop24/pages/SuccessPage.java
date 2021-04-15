package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePageObject{


    By successMyAccountButton = By.xpath("//*[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']");

    public SuccessPage(WebDriver driver, Logger log){
        super(driver,log);
    }


    public LoginPage openLoginPage(){
        log.info("Opening Login page");

        click(successMyAccountButton);

        By logOutButton = By.xpath("//*[text()='Logout']");
        click(logOutButton);

        By logoutMyAccountButton = By.xpath("//*[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']");
        click(logoutMyAccountButton);

        By logInButton = By.xpath("//*[text()='Login']");
        click(logInButton);

        return new LoginPage(driver,log);
    }



}
