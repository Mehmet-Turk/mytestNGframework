package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcRoomReservationCreationPageTest extends TestBase {
    @Test
    public void roomReservationTest(){
        positiveTest.login();
        fhcUsersPage.hotelManagement.click();
        fhcUsersPage.roomReservation.click();
        fhcRoomReservationPage.addRoomReservationButton.click();
        fhcRoomReservationCreationPage.IDUser.sendKeys("manager2");
        fhcRoomReservationCreationPage.IdHotelRoom.sendKeys("Suhrab");
        fhcRoomReservationCreationPage.price.sendKeys("500");
        fhcRoomReservationCreationPage.dateStart.sendKeys("04/24/2020");
        fhcRoomReservationCreationPage.dateEnd.sendKeys("05/24/2020");
        fhcRoomReservationCreationPage.adultAmount.sendKeys("2");
        fhcRoomReservationCreationPage.childrenAmount.sendKeys("3");
        fhcRoomReservationCreationPage.contactNameSurname.sendKeys("Furkan Yilmaz");
        fhcRoomReservationCreationPage.contactPhone.sendKeys("2311232321");
        fhcRoomReservationCreationPage.contactEmail.sendKeys("sanane@gmail.com");
        fhcRoomReservationCreationPage.notes.sendKeys("No notes");
        fhcRoomReservationCreationPage.approved.click();
        fhcRoomReservationCreationPage.isPaid.click();
        fhcRoomReservationCreationPage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(fhcHotelRoomCreationPage.popOpText));
        String actualSuccessMessage = fhcRoomReservationCreationPage.popUpText.getText();
        Assert.assertEquals(actualSuccessMessage, "RoomReservation was inserted successfully");
        fhcRoomReservationCreationPage.popUpButton.click();
    }
    @Test
    public void reservationCreationVerification() throws InterruptedException {
        positiveTest.login();
        fhcUsersPage.hotelManagement.click();
        fhcUsersPage.roomReservation.click();
        fhcRoomReservationPage.contactNameSurnameText.sendKeys("Furkan Yilmaz");
        wait.until(ExpectedConditions.visibilityOf(fhcRoomReservationPage.searchButton));
        fhcRoomReservationPage.searchButton.click();
        wait.until(ExpectedConditions.visibilityOf(fhcRoomReservationPage.cellFinder(1,1)));
        Thread.sleep(2000);
        Assert.assertEquals(fhcRoomReservationPage.cellFinder(1,1).getText(),"63");
    }
}
