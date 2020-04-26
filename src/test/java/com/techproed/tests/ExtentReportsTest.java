package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbTraderRegisterPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportsTest {
    GlbTraderRegisterPage glbTraderRegisterPage = new GlbTraderRegisterPage();
    GlbHomePage glbHomePage = new GlbHomePage();

    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;
    @BeforeTest
    public void setup(){
        extentHtmlReporter = new ExtentHtmlReporter(".\\reports\\extentreports.html");
//        it creates a file to put the reports inside
        extentHtmlReporter.config().setReportName("FHC TRIP AUTOMATION REPORTS");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentHtmlReporter.config().setDocumentTitle("FHC TRIP REPORT");
        extentHtmlReporter.config().setEncoding("UTF-8");

        extentReports = new ExtentReports();//creating extend reports. use it to attach reports
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Automation Tester", "Mehmet");
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("browser", ConfigReader.getProperty("browser"));
    }
    @AfterTest
    public void endReport(){
        extentReports.flush();
    }

    @Test
    public void positiveTest(){
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
