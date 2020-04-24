package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {
    @Test
    public void loginTest() throws InterruptedException {
        /*
        Create a new class: FaceLogin
        Create a test method: logInTest() and test the following user story
        When user enter invalid credentials, we should see sign up page
        https://www.facebook.com/
        Username: fakeusername
        Passwork: fakepassword
=====================================
         */
        driver.get("Https://www.facebook.com/");
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys("fakeusername");
        WebElement passwordBox= driver.findElement(By.id("pass"));
        passwordBox.sendKeys("fakepassowrd");
        WebElement signInButton = driver.findElement(By.id("u_0_b"));
        signInButton.click();
        //Thread.sleep(2000);
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot Password?"));
        Assert.assertTrue(forgotPassword.isDisplayed());


    }
}
