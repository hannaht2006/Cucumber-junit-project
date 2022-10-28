package com.cydeo.step_definitions;

import com.cydeo.pages.EtsySearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class EtsySearch_StepDefinitions {

    EtsySearchPage etsySearchPage = new EtsySearchPage();
    @When("User types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        etsySearchPage.searchBox.sendKeys("wooden spoon");
    }
    @When("User clicks search button")
    public void user_clicks_search_button() {
        etsySearchPage.searchButton.click();
    }
    @Then("User sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains("wooden spoon"));
    }

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String searchkeyword) {

        etsySearchPage.searchBox.sendKeys(searchkeyword);
    }
    @Then("User sees {string} is in the title")
    public void user_sees_is_in_the_title(String expectedwordintitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedwordintitle));

    }
}
