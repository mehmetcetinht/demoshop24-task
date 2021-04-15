package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    By loginEmail = By.xpath("//*[@id='input-email']");
    By loginPassword = By.xpath("//*[@id='input-password']");
    By loginBtn = By.xpath("//*[@value='Login']");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    public MyOrdersPage openMyOrdersPage(String randEmail, String randPass) {
        log.info("Opening my order history page");

        type(randEmail, loginEmail);
        type(randPass, loginPassword);
        click(loginBtn);

        By showOrderHistory = By.xpath("//*[text()='View your order history']");
        click(showOrderHistory);

        return new MyOrdersPage(driver, log);
    }
}
