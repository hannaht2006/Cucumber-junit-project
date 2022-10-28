package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyTitle_StepDefinitions {

    @Given("User is on Etsy home page")
    public void user_is_on_etsy_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
    }


    @Then("User should see Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone")
    public void user_should_see_etsy_shop_for_handmade_vintage_custom_and_unique_gifts_for_everyone() {
        String actualEtsyHomePageTitle = Driver.getDriver().getTitle();
        String expectedEtsyHomePageTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertEquals(expectedEtsyHomePageTitle,actualEtsyHomePageTitle);

    }



}
