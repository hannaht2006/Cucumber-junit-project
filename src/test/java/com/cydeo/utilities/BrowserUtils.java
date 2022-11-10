package com.cydeo.utilities;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void verifyTheTitle (String title){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    public static void clickElement(WebElement element){
//        waitForVisibilityOf(element, 10);
                element.click();
    }
    //methods are static type because we do not want to create an object to call this method. we just call those method with class name

    /**
     * This method is used to pause the code for given seconds
     * It is static method, we can call the method with class name as below:
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        e.printStackTrace();
            System.out.println("exception happened in sleep method");
        }
    }

    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    //BrowserUtils.verifyTitle(driver,"Google")

    public static void verifyTitle(String expectedTitle) {
        // replacing driver ---> Driver.getDriver()
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

    }
    public void switchWindowAndVerify(String expectedInUrl, String expectedTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for(String eachWindow : allWindowHandles){
            Driver.getDriver().switchTo().window(eachWindow);
            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed", actualTitle.contains(expectedTitle));
    }

    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method will accept dropdown as WebElement
     * and return all the options' text in a list of String
     * @return List<String>
     */
    public static List<String> dropdownOptionAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);

//List of all ACTUAL month <options> as WebElement
        List<WebElement> actualMonthAsWebElement = select.getOptions();

//List of all ACTUAL month <options> as String
        List<String> actualMonthAsString = new ArrayList<>();

//with using for loop, we convert each WebElement of options to String with using getText() method and using add() method we store each String in List<String> actualOption as String
        for (WebElement each : actualMonthAsWebElement) {
            actualMonthAsString.add(each.getText());
        }
        return actualMonthAsString;
    }

    /**
     * This method will accept a group of radio button as a List<WebElement>
     * It will loop through the List, and click to the radio button with provilded attribute value
     * @param radioButton
     * @param valueOfAttribute
     */
    public static void clickRadioButton(List<WebElement> radioButton, String valueOfAttribute){
        for (WebElement eachCard : radioButton) {
            if(eachCard.getAttribute("value").equalsIgnoreCase(valueOfAttribute)){
                eachCard.click();
            }
    }
}
}
