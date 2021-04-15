package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //Open page with given URL
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Find element with given locator
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    //Click element with given locator
    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
        log.info("Element: '"+locator+"' is clicked!");
    }

    //Type given text into element with given locator
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
        log.info("Text '"+text+"' is typed to element: "+locator);
    }

    //Get URL of current page from browser
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //Wait for specific ExpectedCondition for the given amount of time in seconds
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    //Wait for given number of seconds for element with given locator to be visible on the page
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    //Create random String with different parameters for different purposes
    protected String random(int index, String type) {
        if (type.equalsIgnoreCase("string")) {
            String alphabet = "abcdefghiklmnoprstvyzx";
            Random rand = new Random();
            String longText = "";
            for (int i = 0; i < index; i++) {
                int randIndex = rand.nextInt(alphabet.length());
                char character = alphabet.charAt(randIndex);
                longText += character;
            }
            log.info("Random string is: " + longText);
            return longText;
        } else if (type.equalsIgnoreCase("both")) {
            String number = "abcdefghiklmnoprstvyzx1234567890";
            Random rand = new Random();
            String longText = "";
            for (int i = 0; i < index; i++) {
                int randIndex = rand.nextInt(number.length());
                char character = number.charAt(randIndex);
                longText += character;
            }
            log.info("Random value is: " + longText);
            return longText;
        } else {
            String number = "1234567890";
            Random rand = new Random();
            String longText = "";
            for (int i = 0; i < index; i++) {
                int randIndex = rand.nextInt(number.length());
                char character = number.charAt(randIndex);
                longText += character;
            }
            log.info("Random integer is: " + longText);
            return longText;
        }
    }

    //Perform mouse over action with given locator
    protected void mouseOver(WebElement locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).build().perform();
        log.info("Mouse is on the element!");
    }

    //Scroll to up or down
    protected void scrollTo(String direction){
        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;

        if(direction.equalsIgnoreCase("down")) {
            jsExecuter.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        else{
            jsExecuter.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
        }
    }

}
