package com.techproed.smoketest;

import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverTest {
    //WebDriver driver = Driver.getDriver();
    @Test
    public void firstNegativeTest(){
        //correct username but incorrect pass
        //open bug ticket!!!!
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FhcLoginPage fhcLoginPage = new FhcLoginPage();
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.loginButton.click();
        String actualWarningMessage = fhcLoginPage.warningMessage.getText();
        Assert.assertTrue(actualWarningMessage.contains(ConfigReader.getProperty("error_message")));
    }

}
