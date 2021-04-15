package com.demoshop24.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePageObject{

    //*********Web Elements*********
    By firstNameBy = By.xpath("//*[@id='input-firstname']");
    By lastNameBy = By.xpath("//*[@id='input-lastname']");
    By emailBy = By.xpath("//*[@id='input-email']");
    By telephoneBy = By.xpath("//*[@id='input-telephone']");
    By passwordBy = By.xpath("//*[@id='input-password']");
    By confirmBy = By.xpath("//*[@id='input-confirm']");
    By continueButton = By.xpath("//*[@value='Continue']");

    public RegisterPage(WebDriver driver, Logger log){
        super(driver,log);
    }


    public SuccessPage SignUp(String randEmail, String randPass){
        log.info("Registering as a new random customer!");
        find(firstNameBy);

        type(random(7,"string"),firstNameBy);
        type(random(7,"string"),lastNameBy);


        log.info("Email is: "+randEmail);
        type(randEmail,emailBy);

        type(random(11,"integer"),telephoneBy);


        log.info("Password is: "+randPass);
        type(randPass,passwordBy);
        type(randPass,confirmBy);

        WebElement agree = driver.findElement(By.xpath("//*[@name='agree']"));
        if (!agree.isSelected()) {
            agree.click();
        }

        click(continueButton);


        return new SuccessPage(driver,log);
    }

}
