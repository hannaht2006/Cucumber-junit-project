package com.cydeo.step_definitions;

import com.cydeo.pages.SmartbearPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class Smartbear_StepDefinitions {
    SmartbearPage smartbearPage = new SmartbearPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.url"));
        smartbearPage.usenameBox.sendKeys(ConfigurationReader.getProperty("userName"));
        smartbearPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        smartbearPage.loginBtn.click();
    }

    @When("User fills out the form as followed:")
    public void user_fills_out_the_form_as_followed() {
        smartbearPage.orderTab.click();
    }

    @When("User selects FamilyAlbum from product dropdown")
    public void user_selects_family_album_from_product_dropdown() {
        Select productDropdownList = new Select(smartbearPage.productDropdown);
        productDropdownList.selectByIndex(1);
    }
    @When("User enters {int} to quantity")
    public void user_enters_to_quantity(Integer int1) {
     smartbearPage.quantityBox.sendKeys("4");
    }

    @When("User enters John Wick to costumer name")
    public void user_enters_john_wick_to_costumer_name() {
    smartbearPage.customerNameBox.sendKeys(ConfigurationReader.getProperty("customerName"));
    }
    @When("User enters Kinzie Ave to street")
    public void user_enters_kinzie_ave_to_street() {
    smartbearPage.streetBox.sendKeys(ConfigurationReader.getProperty("street"));
    }
    @When("User enters Chicago to city")
    public void user_enters_chicago_to_city() {
    smartbearPage.cityBox.sendKeys(ConfigurationReader.getProperty("city"));
    }
    @When("User enters IL to state")
    public void user_enters_il_to_state() {
     smartbearPage.stateBox.sendKeys(ConfigurationReader.getProperty("state"));
    }

    @When("User enters {int}")
    public void user_enters(Integer int1) {
    smartbearPage.zipcodeBox.sendKeys(ConfigurationReader.getProperty("zipcode"));
    }

    @When("User selects Visa as card type")
    public void user_selects_visa_as_card_type() {
    smartbearPage.visaBtn.click();
    }
    @And("User enters {string} to card number")
    public void userEntersToCardNumber(String arg0) {
        smartbearPage.cardBox.sendKeys(ConfigurationReader.getProperty("cardNumber"));
    }
    @And("User enters {string} to expiration date")
    public void userEntersToExpirationDate(String arg0) {
        smartbearPage.dateBox.sendKeys(ConfigurationReader.getProperty("date"));
    }
    @When("User clicks process button")
    public void user_clicks_process_button() {
    smartbearPage.processBtn.click();
    }
    @Then("User verifies John Wick is in the list")
    public void user_verifies_john_wick_is_in_the_list() {

    }



}
