package com.techproed.tests;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GlbHomePageDropDownTest extends TestBase {
    @Test
    public void dropDownTest() {
        GlbHomePage glbHomePage = new GlbHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        Select options = new Select(glbHomePage.dropDown);
        Assert.assertTrue(options.getOptions().stream().map(t->t.getText()).anyMatch(t->t.equals("Furniture")));
    }
}
