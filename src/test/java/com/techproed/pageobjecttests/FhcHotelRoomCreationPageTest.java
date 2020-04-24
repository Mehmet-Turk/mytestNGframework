package com.techproed.pageobjecttests;


import com.techproed.pages.FhcHotelRoomCreationPage;
import com.techproed.pages.FhcHotelRoomsPage;
import com.techproed.pages.FhcUsersPage;
import com.techproed.smoketest.PositiveTest;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcHotelRoomCreationPageTest extends TestBase {
    @Test
    public void hotelRoomCreation(){
        positiveTest.login();
        fhcUsersPage.hotelManagement.click();
        fhcUsersPage.hotelRooms.click();
        fhcHotelRoomsPage.addHotelRoom.click();
        fhcHotelRoomCreationPage.idHotel.sendKeys(fhcHotelRoomCreationPage.idHotelText);
        fhcHotelRoomCreationPage.code.sendKeys(fhcHotelRoomCreationPage.codeText);
        fhcHotelRoomCreationPage.name.sendKeys(fhcHotelRoomCreationPage.nameText);
        fhcHotelRoomCreationPage.description.sendKeys(fhcHotelRoomCreationPage.descriptionText);
        wait.until(ExpectedConditions.visibilityOf(fhcHotelRoomCreationPage.priceAmount));
        actions.dragAndDrop(fhcHotelRoomCreationPage.priceAmount, fhcHotelRoomCreationPage.priceTextBox).perform();
        fhcHotelRoomCreationPage.roomType.sendKeys(fhcHotelRoomCreationPage.roomTypeText);
        fhcHotelRoomCreationPage.maxAdultCount.sendKeys(fhcHotelRoomCreationPage.maxAdultCountText);
        fhcHotelRoomCreationPage.maxChildrenCount.sendKeys(fhcHotelRoomCreationPage.maxChildrenCountText);
        fhcHotelRoomCreationPage.approvedCheckBox.click();
        fhcHotelRoomCreationPage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(fhcHotelRoomCreationPage.popOpText));
        Assert.assertEquals(fhcHotelRoomCreationPage.popOpText.getText(), fhcHotelRoomCreationPage.expectedPopUpText);
        fhcHotelRoomCreationPage.popOpButton.click();
    }
    @Test
    public void hotelRoomCreationVerification() throws InterruptedException {
        fhcLogin.login();
        fhcUsersPage.hotelManagement.click();
        fhcUsersPage.hotelRooms.click();
        Assert.assertTrue(fhcHotelRoomsPage.listOfRoomsText.isDisplayed());
        fhcHotelRoomsPage.codeTextBox.sendKeys(fhcHotelRoomCreationPage.codeText);
        fhcHotelRoomsPage.nameTextBox.sendKeys(fhcHotelRoomCreationPage.nameText);
        wait.until(ExpectedConditions.visibilityOf(fhcHotelRoomsPage.searchButton));
        fhcHotelRoomsPage.searchButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(fhcHotelRoomCreationPage.codeText,fhcHotelRoomsPage.cellFinder(1,3).getText());

    }

}
