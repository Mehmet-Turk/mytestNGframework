package com.techproed.tests;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbTraderRegisterPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReportsTest2 extends TestBaseFinal {
    @Test
    public void positiveTest(){
        GlbTraderRegisterPage glbTraderRegisterPage = new GlbTraderRegisterPage();
        GlbHomePage glbHomePage = new GlbHomePage();
        extentTest = extentReports.createTest("Glb registiration test", "Glb Registration testing");
        extentTest.info("Opening the url");
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        extentTest.info("Clicking on Join button");
        glbHomePage.joinNowButton.click();
        glbTraderRegisterPage.email.sendKeys(ConfigReader.getProperty("glb_valid_email"));
        extentTest.info("Sending user email");
        glbTraderRegisterPage.name.sendKeys(ConfigReader.getProperty("glb_valid_name"));
        extentTest.info("Sending user name");
        glbTraderRegisterPage.phone.sendKeys(ConfigReader.getProperty("glb_valid_phone"));
        extentTest.info("Sending user phone number");
        glbTraderRegisterPage.password.sendKeys(ConfigReader.getProperty("glb_valid_password"));
        extentTest.pass("Sending user password");
        glbTraderRegisterPage.rePassword.sendKeys(ConfigReader.getProperty("glb_valid_password"));
        glbTraderRegisterPage.submitButton.click();
        Assert.assertTrue(glbTraderRegisterPage.successMessage.isDisplayed());
        extentTest.pass("Assertion");
    }
}
