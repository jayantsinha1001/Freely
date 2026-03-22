package com.freely.web.pages;

import com.freely.web.utils.ConfigReader;
import org.openqa.selenium.By;

public class WhatsCoveredPage extends BasePage {

    private final By pageHeading = By.cssSelector("h1");
    private final By coverageItems = By.cssSelector("h2, h3, [class*='coverage-title'], [class*='benefit-title']");
    private final By getQuoteCta = By.cssSelector("a[href*='quote'], button[class*='quote']");

    public void openWhatsCoveredPage() {
        navigateTo(ConfigReader.getUrl("whats.covered.url", "/whats-covered"));
    }

    public boolean isPageDisplayed() {
        return getCurrentUrl().contains("whats-covered");
    }

    public boolean isCoverageItemsDisplayed() {
        return !driver.findElements(coverageItems).isEmpty();
    }

    public void clickGetQuoteCta() {
        clickElement(getQuoteCta);
    }
}
