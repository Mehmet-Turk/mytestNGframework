package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbTraderRegisterPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbTraderRegistrationTest {
    @Test
    public void positiveTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        GlbTraderRegisterPage glbTraderRegisterPage = new GlbTraderRegisterPage();
        GlbHomePage glbHomePage = new GlbHomePage();
        glbHomePage.joinNowButton.click();
        glbTraderRegisterPage.email.sendKeys(ConfigReader.getProperty("glb_valid_email"));
        glbTraderRegisterPage.name.sendKeys(ConfigReader.getProperty("glb_valid_name"));
        glbTraderRegisterPage.phone.sendKeys(ConfigReader.getProperty("glb_valid_phone"));
        glbTraderRegisterPage.password.sendKeys(ConfigReader.getProperty("glb_valid_password"));
        glbTraderRegisterPage.rePassword.sendKeys(ConfigReader.getProperty("glb_valid_password"));
        glbTraderRegisterPage.submitButton.click();
        Assert.assertTrue(glbTraderRegisterPage.successMessage.isDisplayed());
    }
}
