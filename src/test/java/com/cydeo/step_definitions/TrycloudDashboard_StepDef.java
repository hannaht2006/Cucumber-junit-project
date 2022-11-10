package com.cydeo.step_definitions;

import com.cydeo.pages.TrycloudDashboardPage;
import com.cydeo.pages.TrycloudLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class TrycloudDashboard_StepDef {

    TrycloudLoginPage trycloudLoginPage = new TrycloudLoginPage();
    @When("user  log in with valid credentials")
    public void user_log_in_with_valid_credentials() {
     trycloudLoginPage.login();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String>expectedModulesNames) {
        List<String> actualModulesNames = new TrycloudDashboardPage().getModulesText();
        Assert.assertEquals(expectedModulesNames,actualModulesNames);
    }

}
