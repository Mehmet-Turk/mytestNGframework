package com.techproed.smoketest;

import com.techproed.pages.FhcLoginPage;
import com.techproed.pages.FhcUsersPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {
    @Test (groups = "regression1")
    public void positiveLoginTest(){
        login();
        FhcUsersPage fhcUsersPage =new FhcUsersPage();
        Assert.assertTrue(fhcUsersPage.listOfUsersText.isDisplayed());
    }
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FhcLoginPage fhcLoginPage = new FhcLoginPage();
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.loginButton.click();
    }
}
