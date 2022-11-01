package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //creating a private constructor, we are closing access to the object of this class from outside
    private Driver(){}

    //creating our "driver" instance private --> not reachable from outside class. made it static because want to use it in static method
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    creating re-usable utility method which same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if(driverPool.get()==null){ //if driver/browser was never opened
            String browserType = ConfigurationReader.getProperty("browser");
            /*
            depending on browser type our switch statement will determine to open specific type of browser/driver
             */
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                 break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        //same driver instance will be return every time we call Driver.getDriver() method
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get()!= null){
            driverPool.get().quit(); //this line will kill the session. value will now be null
            driverPool.remove();
        }
    }

}
