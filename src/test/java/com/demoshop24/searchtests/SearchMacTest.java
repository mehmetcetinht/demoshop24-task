package com.demoshop24.searchtests;

import com.demoshop24.base.TestUtilities;
import com.demoshop24.pages.DesktopPage;
import com.demoshop24.pages.HomePageObject;
import com.demoshop24.pages.IMacPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchMacTest extends TestUtilities {


    @Test()
    public void SearchMacTest() {
        //open home page
        HomePageObject homePageObject = new HomePageObject(driver,log);
        homePageObject.openPage();


        //Open Desktops page
        DesktopPage desktopPage = homePageObject.openDesktopPage();

        //Verify that Desktops page opens
        checkUrl("http://www.demoshop24.com/index.php?route=product/category&path=20_27");
        takeScreenshot("iMacAtDesktop");
        desktopPage.openIMacPage();

        //Open iMac page
        IMacPage iMacPage = new IMacPage(driver,log);
        takeScreenshot("iMacProductPage");
        //Verify the brand,price and
        Assert.assertTrue(iMacPage.getBrandText().contains("Apple"), "Actual Brand should contain 'Apple'");
        Assert.assertTrue(iMacPage.getPriceText().contains("$122"), "Actual Price should contain '$122'");
        Assert.assertTrue(iMacPage.getProductCodeText().contains("Product 14"), "Actual Product Code should contain 'Product 14'");

    }

}
