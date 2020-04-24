package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssertions {
    WebDriver driver;
    /*
    When user goes to http://a.testaddressbook.com/sign_in
    Locate the elements of email textbox,password textbox, and signin button
    Enter below username and password then click sign in button
    Username :  testtechproed@gmail.com
    Password : Test1234!
    Then Assert/Verify that the expected user id  testtechproed@gmail.com using different assertions
     */
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }
    @Test
    public void login(){
        WebElement emailCheckBox = driver.findElement(By.xpath("//input[@id='session_email']"));
        emailCheckBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordCheckBox = driver.findElement(By.id("session_password"));
        passwordCheckBox.sendKeys("Test1234!");
        WebElement singInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        singInButton.click();
    }
    @Test(dependsOnMethods = "login")
    public void signInVerification(){
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        WebElement actualuserId = driver.findElement(By.xpath("//span[@class='navbar-text']"));
        String expectedUserId = "testtechproed@gmail.com";
        Assert.assertEquals(actualuserId.getText(), expectedUserId);//HARD ASSERT
        System.out.println("This is hard assertion so if fails it will not printing ");

        //Soft assert does not affect the test it will not fail the case
        SoftAssert softAssert = new SoftAssert();//CREATING SOFT ASSERT OBJECT
        softAssert.assertTrue(welcomeMessage.isDisplayed());//USAGE OF SOFT ASSERT
        System.out.println("This is soft assertion message it will be seen any case!!");
        softAssert.assertAll();//fails all method if softassert fails
        //WITH OUT ASSERTALL SOFT ASSERT WONT MAKE SENSE BECAUSE NO SOFT ASSERT WONT
        //FAIL THE METHOD NO REPORT TO SEE

    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
