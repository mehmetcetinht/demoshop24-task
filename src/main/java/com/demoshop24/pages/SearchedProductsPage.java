package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchedProductsPage extends BasePageObject {

    public SearchedProductsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    By searchedElement = By.xpath("//*[@value='Samsung SyncMaster 941BW']");
    By searchedProduct = By.className("price");
    By addToCartButton = By.xpath("//*[text()='Add to Cart']");
    By cartWithProduct = By.xpath("//*[@id='cart-total']");


    public boolean isSearchedElementVisible() {
        return find(searchedElement).isDisplayed();
    }

    public String getPrizeText() {
        return find(searchedProduct).getText();
    }

    public void addItemToCart() {
        scrollTo("down");
        click(addToCartButton);
        scrollTo("up");
    }

    public String getPrizeInCart() {
        return find(cartWithProduct).getText();
    }

    public CartPage openCartPage(){
        click(cartWithProduct);
        By viewCart = By.xpath("//*[contains(text(),'View Cart')]");
        click(viewCart);
        return new CartPage(driver,log);
    }
}
