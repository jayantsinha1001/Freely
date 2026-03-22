package com.freely.web.stepdefs;

import com.freely.web.pages.WhatsCoveredPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class NavigationSteps {

    WhatsCoveredPage whatsCoveredPage = new WhatsCoveredPage();

    @Given("I am on the whats covered page")
    public void iAmOnTheWhatsCoveredPage() {
        whatsCoveredPage.openWhatsCoveredPage();
    }


    @Then("the whats covered page should be displayed")
    public void theWhatsCoveredPageShouldBeDisplayed() {
        Assert.assertTrue("What's Covered page is not displayed", whatsCoveredPage.isPageDisplayed());
    }

    @Then("coverage items should be listed on the page")
    public void coverageItemsShouldBeListedOnThePage() {
        Assert.assertTrue("No coverage items found on the page", whatsCoveredPage.isCoverageItemsDisplayed());
    }

    @When("I click Get Quote from the whats covered page")
    public void iClickGetQuoteFromTheWhatsCoveredPage() {
        whatsCoveredPage.clickGetQuoteCta();
    }

}
