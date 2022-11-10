package com.cydeo.step_definitions;

import com.cydeo.pages.TrycloudLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TryCloudLogin_StepDef {
  TrycloudLoginPage trycloudLoginPage = new TrycloudLoginPage();
    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("Trycloud.url"));
    }
    @When("user enter valid {string} and {string}")
    public void user_enter_valid_and(String username, String password) {

        // create a method
        //for mac : option+enter
        //for window: alt+enter
        trycloudLoginPage.login(username, password);
    }
    @When("user click login button")
    public void user_click_login_button() {
      BrowserUtils.clickElement(trycloudLoginPage.loginBtn);
    }
    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {
    BrowserUtils.verifyTheTitle("Dashboard");
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {

    }

}
