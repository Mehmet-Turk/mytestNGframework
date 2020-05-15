package com.techproed.utilities;

import com.techproed.pages.*;
import com.techproed.smoketest.PositiveTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;



public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    protected PositiveTest positiveTest;
    protected FhcHotelRoomCreationPage fhcHotelRoomCreationPage;
    protected FhcUsersPage fhcUsersPage ;
    protected FhcHotelRoomsPage fhcHotelRoomsPage ;
    protected FhcLoginPage fhcLoginPage ;
    protected FhcRoomReservationPage fhcRoomReservationPage;
    protected FhcRoomReservationCreationPage fhcRoomReservationCreationPage;
    protected FhcLogin fhcLogin;
    @BeforeMethod
    public void setUp(){
        actions = new Actions(Driver.getDriver());
        wait = new WebDriverWait(Driver.getDriver(), 20);
        fhcHotelRoomCreationPage = new FhcHotelRoomCreationPage();
        fhcUsersPage = new FhcUsersPage();
        fhcHotelRoomsPage = new FhcHotelRoomsPage();
        fhcLoginPage = new FhcLoginPage();
        fhcRoomReservationPage = new FhcRoomReservationPage();
        fhcRoomReservationCreationPage = new FhcRoomReservationCreationPage();
        positiveTest = new PositiveTest();
        fhcLogin = new FhcLogin();
    }
//    @AfterMethod
//    public void tearDown(){
//       // driver.quit();
//    }
}
