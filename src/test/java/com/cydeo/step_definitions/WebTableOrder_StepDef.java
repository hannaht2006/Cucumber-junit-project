package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.pages.WebTableOrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebTableOrder_StepDef {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    WebTableOrderPage webTableOrderPage = new WebTableOrderPage();

    Select select;// create Select object global

    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("webtable.env"));
        webTableLoginPage.login(ConfigurationReader.getProperty("webTable.username"), ConfigurationReader.getProperty("webTable.password"));

        basePage.orderButtonNavItem.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        select = new Select(webTableOrderPage.productField);
        select.selectByVisibleText(string);

    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {

        //default there was already number in this input -->
        //first we need to clear that input, and we will send keys after that
        //webTableOrderPage.quantityField.clear();
        webTableOrderPage.quantityField.sendKeys(Keys.BACK_SPACE);
        //senKeys() only accept String --> convert int1 to String by concat with "" or :
        //using the wrap method :.sendKeys(String.valueOf(int1))
        webTableOrderPage.quantityField.sendKeys(int1+"");
    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {

        webTableOrderPage.customerNameField.sendKeys(customerName);
    }
    @When("user enters street {string}")
    public void user_enters_street(String street) {

        webTableOrderPage.street.sendKeys(street);

    }
    @When("user enters city {string}")
    public void user_enters_city(String city) {

        webTableOrderPage.city.sendKeys(city);
    }
    @When("user enters state {string}")
    public void user_enters_state(String state) {

        webTableOrderPage.state.sendKeys(state);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String zip) {

        webTableOrderPage.zipcod.sendKeys(zip);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String card) {

//        for (WebElement eachCard : webTableOrderPage.cardType) {
//            if(eachCard.getAttribute("value").equalsIgnoreCase(card)){
//                eachCard.click();
//            }
//        }

        BrowserUtils.clickRadioButton(webTableOrderPage.cardType, card);

    }

   @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String cardNumber) {
       webTableOrderPage.creditCardNumber.sendKeys(cardNumber);

    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String expDate) {
       webTableOrderPage.exprirationDate.sendKeys(expDate);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {

        webTableOrderPage.processOrderBtn.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedText) {

     String actualNameInFirstRowOfWebTable = viewAllOrdersPage.customerNameInFirstRow.getText();

        Assert.assertEquals(expectedText, actualNameInFirstRowOfWebTable);
    }
}
