package com.demoshop24.searchtests;

import com.demoshop24.base.TestUtilities;
import com.demoshop24.pages.CartPage;
import com.demoshop24.pages.HomePageObject;
import com.demoshop24.pages.SearchedProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchSamsungTest extends TestUtilities {


    @Test()
    public void SearchSamsungTest() {
        //open home page
        HomePageObject homePageObject = new HomePageObject(driver, log);
        homePageObject.openPage();


        //Search Samsung device
        SearchedProductsPage searchedProductsPage = homePageObject.openSearchedProductsPage();
        sleep(3000);

        //Verify that the searched product is Samsung SyncMaster 941BW!
        Assert.assertTrue(searchedProductsPage.isSearchedElementVisible(), "Searched item is not in page or is not displayed!");
        Assert.assertTrue(searchedProductsPage.getPrizeText().contains("$242.00"), "Searched product prize should be '$242.00'");
        takeScreenshot("Samsung searched");

//      Add item to cart
        searchedProductsPage.addItemToCart();
        sleep(2000);
        Assert.assertTrue(searchedProductsPage.getPrizeInCart().contains("$242.00"), "Searched product prize should be '$242.00'");
        searchedProductsPage.openCartPage();

//		Verify url of cart page and total prize
        CartPage cartPage = new CartPage(driver,log);
        checkUrl("http://www.demoshop24.com/index.php?route=checkout/cart");
        takeScreenshot("CartPage opened");
        Assert.assertTrue(cartPage.getTotalPrizeInCart().contains("$242.00"), "Total product prize in cart should be '$242.00'");

    }

}
