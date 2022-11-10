package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.BrowserUtilsAsyun;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TrycloudDashboardPage {
    public TrycloudDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//ul[@id='appmenu']//li")
    public List<WebElement> modules1;


    public List<String> getModulesText(){

        List<String> modulesText = new ArrayList<>();

        for(int i=0; i<modules1.size()-1; i++){
            BrowserUtilsAsyun.hover(modules1.get(i));
            BrowserUtils.sleep(2);
            modulesText.add(modules1.get(i).getText());

        }
        return modulesText;
    }
}
