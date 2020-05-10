package com.techproed.tests;

import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NegativeTestCase extends TestBaseFinal {
    FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
    @Test(invocationCount = 1, enabled = false)//it runs the testcase as number === enables not to run or run
    public void invalidPass() throws InterruptedException {
        extentTest=extentReports.createTest("TEST NAME","NEGATIVE TEST");
        extentTest.info("Opening the URL");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        extentTest.info("creating page object");
        //correct username but incorrect pass
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        extentTest.info("clicking");
        fhcLoginPage.loginButton.click();
        Thread.sleep(3000);
        extentTest.info("verifying");
        Assert.assertFalse(fhcLoginPage.warningMessage.getText().contains(ConfigReader.getProperty("login_error_message")));
        extentTest.pass("PASSED");
    }
    @Test(groups = "regression1")
    public void invalidID(){
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        // Correct pass but inccorrect username
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.loginButton.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.warningMessage.getText().contains(ConfigReader.getProperty("login_error_message2")));
    }
    @Test(groups = "regression1")
    public void invalidIDAndPass(){
        Driver.getDriver().get("http://www.fhctrip.com/Account/Logon");
        //Both incorrect username password
        fhcLoginPage.username.sendKeys("minagr2");
        fhcLoginPage.password.sendKeys("Man2ager2");
        fhcLoginPage.loginButton.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.warningMessage.getText().contains("Try again please"));
    }
}
