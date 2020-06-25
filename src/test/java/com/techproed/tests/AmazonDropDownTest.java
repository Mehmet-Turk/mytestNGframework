package com.techproed.tests;

import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseFinal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmazonDropDownTest extends TestBaseFinal {
    /*Go to https://www.amazon.ca/
    Find the element of the dropdown element. HINT: By.id("searchDropdownBox")
    Print the first selected option and assert if it equals “All Departments”
    Select the 4th option by index (index of 3) and assert if the name is “Amazon Warehouse Deals”.
    (after you select you need to use get first selected option method)
    Print all of the dropdown options
    Print the number of elements in the dropdown.
    BONUS : Check if Appliances is a drop down option. Print true if “Appliances” is
    an option. Print false otherwise.
     */
    @Test
    public void dropdownTest (){

        driver.get("https://www.amazon.ca/");
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select options = new Select(dropdown);
        String firstSelected= options.getFirstSelectedOption().getText();
        Assert.assertEquals(firstSelected, "All Departments");
        options.selectByIndex(3);
        String fourthOption = options.getFirstSelectedOption().getText();
        Assert.assertEquals(fourthOption,"Amazon Warehouse Deals");
        List<WebElement> allOptions = options.getOptions();
        for (WebElement e : allOptions){
            System.out.println(e.getText());
        }
        System.out.println("There are " + allOptions.size()+" options in the dropdown menu");
        boolean flag = false;
        System.out.println(allOptions.contains("Appliances")?"True":"False");
//        for ( WebElement e: allOptions){
//            if (e.getText().equals("Appliances")){
//               flag = true;
//            }
//        }
//        if (flag == true){
//            System.out.println("There is option like Appliances in the dropdown");
//        }else{
//            System.out.println("There is no option like Appliances in the dropdown");
//        }

        List <String> sortedOptions = new ArrayList<String>();
        for (WebElement e : allOptions){
            sortedOptions.add(e.getText());
        }
        Collections.sort(sortedOptions);

        System.out.println(allOptions.equals(sortedOptions) ? "TRUE" : "FALSE");


    }
}
