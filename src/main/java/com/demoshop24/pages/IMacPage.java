package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMacPage extends BasePageObject{

    public IMacPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    By brand = By.xpath("//*[@href='http://www.demoshop24.com/index.php?route=product/manufacturer/info&manufacturer_id=8']");
    By price = By.xpath("//*[text()='$122.00']");
    By productCode = By.xpath("//*[contains(text(),'Product Code:')]");


    public String getBrandText(){
        return find(brand).getText();
    }

    public String getPriceText(){
        return find(price).getText();
    }

    public String getProductCodeText(){
        return find(productCode).getText();
    }
}
