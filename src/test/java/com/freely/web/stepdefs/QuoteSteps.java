package com.freely.web.stepdefs;

import com.freely.web.pages.QuotePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class QuoteSteps {

    QuotePage quotePage = new QuotePage();

    @Given("I am on the travel insurance quote page")
    public void iAmOnTheTravelInsuranceQuotePage() {
        quotePage.openQuotePage();
    }

    @When("I enter destination {string}")
    public void iEnterDestination(String destination) {
        quotePage.enterDestination(destination);
//        quotePage.selectFromSearchDropdown(destination);
    }
    @Then("I click on checkbox")
    public void i_click_on_checkbox() {
        quotePage.clickOncheckobox();
    }

    @Then("I click on next button")
    public void i_click_on_next_button() {
        quotePage.clickOnNext();

    }
    @When("I enter departure date {string}")
    public void iEnterDepartureDate(String date) {
        quotePage.enterDepartureDate(date);
    }

    @When("I enter return date {string}")
    public void iEnterReturnDate(String date) {
        quotePage.enterReturnDate(date);
    }

    @When("I enter traveller age {string}")
    public void iEnterTravellerAge(String age) {
        quotePage.enterTravellerAge(age);
    }

    @When("I click Get Quote")
    public void iClickGetQuote() {
        quotePage.clickGetQuote();
    }

    @Then("the quote page should be displayed")
    public void theQuotePageShouldBeDisplayed() {
        Assert.assertTrue("Quote page is not displayed", quotePage.isQuotePageDisplayed());
    }

    @Given("I am on the us home page")
    public void i_am_on_the_us_home_page() {
        quotePage.openusquotepage();
    }

    @Then("the us quote page should be displayed")
    public void the_us_quote_page_should_be_displayed() {
        quotePage.isusquotepagedisplayed();
    }
    @When("I selects {string} as residence")
    public void i_selects_as_residence(String state) {
        quotePage.selectStateDropdown(state);
    }

}
