package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    /*
    Create a class:FileDownload
    Create two test method: isExist() and downloadTest()
In the downloadTest() method, do the following test:
Go to https://the-internet.herokuapp.com/download
Download text.txt file
Then verify if the file downloaded successfully.
     */
    @Test
    public void isExist(){
        String currentFolderPath = System.getProperty("user.dir");//gives the current folder in string
        System.out.println("Current Folder==> "+ currentFolderPath);

        //go to user.home and gives back path user path in string
        String userHomePath= System.getProperty("user.home");
        System.out.println("USer Folder==> "+ userHomePath);

        String pathOfFile = userHomePath+"/Downloads/logo9.png";
        //now i have the path of the file, I can verify if it exist or not
        boolean isExists = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isExists);
    }
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("logo9.png")).click();
        Thread.sleep(500);//we need to put wait for downloading
        //this is hard wait and it will wait no matter happens although it finds in 1 sec
        String userFolder = System.getProperty("user.home");
        //finding the path of the downloaded file
        //i can use /Users/user/Downloads.upload.jpg
        String pathOfFile = userFolder + "/Downloads/logo9.png";//setting file path downloaded
        boolean isDownloaded = Files.exists(Paths.get(pathOfFile));


        Assert.assertTrue(isDownloaded);

    }
}
