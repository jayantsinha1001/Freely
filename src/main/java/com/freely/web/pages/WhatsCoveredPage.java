package com.freely.web.pages;

import com.freely.web.utils.ConfigReader;
import org.openqa.selenium.By;

public class WhatsCoveredPage extends BasePage {

    private final By coverageItems = By.cssSelector("h2, h3, [class*='coverage-title'], [class*='benefit-title']");
    private final By getQuoteCta = By.cssSelector("a[href*='quote'], button[class*='quote']");
    private final By pageheading = By.xpath("//*[@id='root'']/div/main/div/h2");



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
        switchToNewTab();
    }

    public void verifygetquotepage(){
        isElementDisplayed(pageheading);
    }
}
