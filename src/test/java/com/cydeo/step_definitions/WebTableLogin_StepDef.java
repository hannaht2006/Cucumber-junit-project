package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebTableLogin_StepDef {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    @Given("user is on login page of the web table app")
    public void user_is_on_login_page_of_the_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webtable.env"));
    }
    @When("user enters username {string}")
    public void user_enters_username(String string) {
    webTableLoginPage.inputUsername.sendKeys(string);
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
    webTableLoginPage.inputPassword.sendKeys(string);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
    webTableLoginPage.loginBtn.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("order") );
    }

}
