package com.demoshop24.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestUtilities extends BaseTest {

    //Static Sleep
    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String random(int index, String type) {
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

    public void checkUrl(String url) {
        sleep(2000);
        String expectedUrl = url;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
        log.info("Current url is: " + url);
    }

    // Take screenshot
    protected void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + getTodaysDate()
                + File.separator + testSuiteName
                + File.separator + testName
                + File.separator + testMethodName
                + File.separator + getSystemTime()
                + " " + fileName + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Todays date in yyyyMMdd format
    private static String getTodaysDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    // Current time in HHmmssSSS
    private String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    // Get logs from browser console
    protected List<LogEntry> getBrowserLogs() {
        LogEntries log = driver.manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }

}
