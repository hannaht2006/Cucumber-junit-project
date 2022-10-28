package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario){
        //Scenario in the parameter comes from cucumber-java
        //we will implement taking screenshot in this method
        //  System.out.println("It will close browser using cucumber @After each scenario");

        //we need to down casting interface TakesScreenshot to take screenshot and store in an Array byte (BECAUSE picture is byte data type(pixel)
        //attach()method requires to store in Array
        //and we need to attach the screenshot to Scenario

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }

       Driver.closeDriver();
    }




    //pick Before from cucumber option then we can access to the scenarios from feature file (junit only control in this class provide assertion)
    //run before each scenario
 //   @Before//(order = 1)
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
        Driver.getDriver().get("url of your app");
    }

//    @Before(value = "@Login", order = 2)
//    public void setupForLogin(){
//    //if you want any code to run before any specific feature /scenario
//    //you can use value = "@Tagname" to determine this
//    }
//
//    @Before( value = "@db", order = 3)
//    public void setupDatabaseScenario(){
//
//    }



 //   @BeforeStep
    public void setupScenerioStep(){

    }


//    @BeforeStep
    public void setupScenarioStepsForLogin(){

    }
}
