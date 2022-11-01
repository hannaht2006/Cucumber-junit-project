package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTableOrderPage extends BasePage {
    public WebTableOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//select[@name='product']")
    public WebElement productField;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement quantityField ;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement customerNameField;

    @FindBy(xpath = "//input[@name='street']")
    public WebElement street;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipcod;

    @FindBy(name = "card")
    public List<WebElement> cardType;

    /*since cardtype is radio button , so we use List to store those web element
    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanexpressType;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaType;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterType;
*/
    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement creditCardNumber;

    @FindBy(xpath = "//input[@name='cardExp']")
    public WebElement exprirationDate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderBtn;



}
