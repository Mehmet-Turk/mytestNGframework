package com.techproed.smoketest;

import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NegativeTest {
    FhcLoginPage fhcLoginPage = new FhcLoginPage();
    @Test(groups = "regression1")
    public void firstNegativeTest(){
        //correct username but incorrect pass
        //open bug ticket!!!!
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.loginButton.click();
        String actualWarningMessage = fhcLoginPage.warningMessage.getText();
        Assert.assertTrue(actualWarningMessage.contains(ConfigReader.getProperty("error_message")));
    }
    @Test
    public void secondNegativeTest(){
        //Correct pass but incorrect username
        //open bug ticket!!!!!! for user name ==> Manager2
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.loginButton.click();
        String actualWarningMessage = fhcLoginPage.warningMessage.getText();
        Assert.assertTrue(actualWarningMessage.contains(ConfigReader.getProperty("error_message")));
    }
    @Test(groups = "regression1")
    public void ThirdNegativeTest(){
        //both incorrect
        //open bug ticket!!!! pass==>man1ager2!
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.loginButton.click();
        String actualWarningMessage = fhcLoginPage.warningMessage.getText();
        Assert.assertTrue(actualWarningMessage.contains(ConfigReader.getProperty("error_message")));

    }



}

