package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragDropExample extends TestBase {
    @Test
    public void drag(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement a = Driver.getDriver().findElement(By.id("column-a"));
        WebElement b = Driver.getDriver().findElement(By.id("column-b"));
        actions.dragAndDrop(b,a);

    }
}
