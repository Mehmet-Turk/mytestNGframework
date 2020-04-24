package com.techproed.pageobjecttests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void FirstObjectTest(){

        driver.get("Https://www.facebook.com/");
        FaceLoginPage faceLoginPage=new FaceLoginPage();

        faceLoginPage.email.sendKeys("fake_username");
        faceLoginPage.password.sendKeys("fake_user_pass");
        faceLoginPage.submitButton.click();
    }
}
