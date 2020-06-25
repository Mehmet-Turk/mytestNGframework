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
        //starting the reporter and setting the path. it creates reports folder and extentreports file root level
        extentHtmlReporter = new ExtentHtmlReporter(".\\reports\\extentreports.html");
//        it creates a file to put the reports inside
        //doing configuration (optional) arranging inside of the report
        extentHtmlReporter.config().setReportName("FHC TRIP AUTOMATION REPORTS");//setting report name
        extentHtmlReporter.config().setTheme(Theme.DARK);//theme, changing color
        extentHtmlReporter.config().setDocumentTitle("FHC TRIP REPORT");//setting document title
        extentHtmlReporter.config().setEncoding("UTF-8");//setting language

        extentReports = new ExtentReports();//creating extend reports. use it to attach reports
        extentReports.attachReporter(extentHtmlReporter);//attaching report
        //after this are optional
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
        //extentTest.pass("Sending user password");
        glbTraderRegisterPage.rePassword.sendKeys(ConfigReader.getProperty("glb_valid_password"));
        glbTraderRegisterPage.submitButton.click();
        Assert.assertTrue(glbTraderRegisterPage.successMessage.isDisplayed());
        //extentTest.pass("Assertion");
        extentTest.fail("fail");
    }
}
