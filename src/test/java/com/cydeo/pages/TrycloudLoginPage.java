package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrycloudLoginPage {

    public TrycloudLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

    }

    public void login(){
        login(ConfigurationReader.getProperty("TCusername"),ConfigurationReader.getProperty("TCpassword") );
        loginBtn.click();
    }
}
