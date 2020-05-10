package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSearchPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSearchTest {
    @Test
    public void searchTest(){
        GlbSearchPage glbSearchPage = new GlbSearchPage();
        GlbHomePage glbHomePage = new GlbHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        glbHomePage.searchButton.click();
        glbSearchPage.allProducts.stream().map(t->t.getText() + " | ").forEach(System.out::println);
        Assert.assertTrue(glbSearchPage.allProducts.stream().map(t->t.getText()).anyMatch(t->t.contains("Camera")));
        Assert.assertEquals(glbSearchPage.allProducts.stream().map(t->t.getText()).count(), 20);




    }
}
