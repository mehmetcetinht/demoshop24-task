package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DesktopPage extends BasePageObject{

    public DesktopPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    By iMacElement = By.xpath("//*[text()='iMac']");

    public IMacPage openIMacPage() {
        log.info("Opening iMac product page");
        click(iMacElement);
        return new IMacPage(driver, log);
    }
}
