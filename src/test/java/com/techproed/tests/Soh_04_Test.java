package com.techproed.tests;

import com.techproed.soh.Soh_Day_04_page;
import com.techproed.soh.Soh_sauce_productPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Soh_04_Test  extends TestBaseFinal {
    Soh_Day_04_page soh_day_04 = new Soh_Day_04_page();
    Soh_sauce_productPage soh_sauce_productPage = new Soh_sauce_productPage();

    @Test
    public void saucedemoLogin(){
        Driver.getDriver().get(soh_day_04.url);
        soh_day_04.username.sendKeys("standard_user");
        soh_day_04.password.sendKeys("secret_sauce");
        soh_day_04.loginButton.click();
        String actualText = soh_sauce_productPage.productText.getText();
        String expectedText = "Products";
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void errorMessageVerification(){
        Driver.getDriver().get(soh_day_04.url);
        soh_day_04.username.sendKeys("locked_out_user");
        soh_day_04.password.sendKeys("secret_sauce");
        soh_day_04.loginButton.click();
        String actualErrorMessage = soh_day_04.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains(soh_day_04.expectedErrorMessage));
    }
}
