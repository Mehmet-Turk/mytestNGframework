package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase {
    /*
Create a class: HotelRoomCreation
Create a Method: RoomCreateTest()
When user goes to http://www.fhctrip.com/admin/HotelRoomAdmin
Username=>manager2
Password=>Man1ager2!
And fills out all of the required fields
Then click on save button
And Verify the text message on the pop up “HotelRoom was inserted successfully”

     */
    @Test
    public void RoomCreateTest() throws InterruptedException {
        Driver.getDriver().get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        //entering page
        WebElement userName = Driver.getDriver().findElement(By.id("UserName"));
        userName.sendKeys("manager2");
        WebElement password = Driver.getDriver().findElement(By.id("Password"));
        password.sendKeys("Man1ager2!");
        //driver.findElement(By.id("RememberME")).click();
        Driver.getDriver().findElement(By.xpath("//button")).click();
        //clicking on add hotelroom
        WebElement addHotelRoom = Driver.getDriver().findElement(By.xpath("//span[@class='hidden-480']"));
        addHotelRoom.click();
        //selecting on dropdown
        WebElement idHotel = Driver.getDriver().findElement(By.id("IDHotel"));
        idHotel.sendKeys("BugShooters Hotel");
        //selecting by select objects
//        Select select = new Select(idHotel);
//        select.selectByIndex(4);
        //entering code
        WebElement codeTextBox = Driver.getDriver().findElement(By.id("Code"));
        codeTextBox.sendKeys("272732");
        //entering name
        WebElement nameTextBox = Driver.getDriver().findElement(By.id("Name"));
        nameTextBox.sendKeys("Victoria");
        //entering description

        WebElement descriptionTextBox = Driver.getDriver().findElement(By.xpath("//textarea[@dir='ltr']"));
        descriptionTextBox.sendKeys("Happy holidays");

        //Thread.sleep(1000);//sync issue so wait for performing drag drop

        //entering price
        WebElement priceTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Price")));
        WebElement price = Driver.getDriver().findElement(By.xpath("//li[@data-id='500']"));
        actions.dragAndDrop(price,priceTextBox).perform();

        //selecting room type
        WebElement roomType = Driver.getDriver().findElement(By.id("IDGroupRoomType"));
        roomType.sendKeys("Queen");

        //entering number of adults
        WebElement numberOfAdultsTextBox = Driver.getDriver().findElement(By.id("MaxAdultCount"));
        numberOfAdultsTextBox.sendKeys("2");

        //entering number of children
        WebElement numberOfChildrenTextBox = Driver.getDriver().findElement(By.id("MaxChildCount"));
        numberOfChildrenTextBox.sendKeys("1");

        //clicking approved
        WebElement approvedCheckBox = Driver.getDriver().findElement(By.id("uniform-IsAvailable"));
        approvedCheckBox.click();

        //clicking on save button
        WebElement saveButton = Driver.getDriver().findElement(By.id("btnSubmit"));
        saveButton.click();
        //
        WebElement alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
       // or i can use wait.until(ExpectedConditions.textToBe(xpath, value)
        String actualAlertText= Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).getText();
       String expectedAlertText = "HotelRoom was inserted successfully";
        Assert.assertEquals(actualAlertText,expectedAlertText);

        WebElement popUpButton = Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']"));
        popUpButton.click();

        //turning back hotel room page
        WebElement hotelRoomsLink=wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
        Thread.sleep(3000);
        actions.doubleClick(hotelRoomsLink).perform();
       //driver.navigate().back();
       

        //locating list of room
        boolean isLocated = Driver.getDriver().findElement(By.xpath("//span[@class='caption-subject font-green-sharp bold uppercase']")).isDisplayed();
        Assert.assertTrue(isLocated);

        //locating code search
        WebElement codeSearch = Driver.getDriver().findElement(By.name("Code"));
        codeSearch.sendKeys("272732");
        //clicking on search button
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-sm yellow filter-submit margin-bottom']")));
        searchButton.click();
        Thread.sleep(1000);

        //verifying hotel

        String actualHotelId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sorting_1']"))).getText();
        String expectedHotelId = "BugShooters Hotel";
        Assert.assertEquals(actualHotelId,expectedHotelId);








    }
}
