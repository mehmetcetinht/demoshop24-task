package com.demoshop24.logintest;


import com.demoshop24.base.TestUtilities;
import com.demoshop24.pages.*;
import org.testng.annotations.*;


public class LoginTest extends TestUtilities {


    @Test()
    public void LoginTest() {
        //open home page
        HomePageObject homePageObject = new HomePageObject(driver,log);
        homePageObject.openPage();


        //Open Register page
        RegisterPage registerPage = homePageObject.openRegisterPage();
        takeScreenshot("RegisterPage opened");

        //Register with random variables
        String randEmail = random(7,"both")+"@testmail.com";
        String randPass = random(8, "both");
        SuccessPage successPage = registerPage.SignUp(randEmail,randPass);


        //Verify that register succeed
        checkUrl("http://www.demoshop24.com/index.php?route=account/success");
        takeScreenshot("SuccessPage opened");

        //User logout and the login then opens order history page
        LoginPage loginPage = successPage.openLoginPage();
        loginPage.openMyOrdersPage(randEmail,randPass);


        //Verify Order History page
        checkUrl("http://www.demoshop24.com/index.php?route=account/order");

        MyOrdersPage myOrdersPage = new MyOrdersPage(driver,log);
        myOrdersPage.isOrderHistoryTextVisible();
        takeScreenshot("OrderHistory opened");
    }





}
