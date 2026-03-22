package com.freely.web.pages;

import com.freely.web.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuotePage extends BasePage {

    private final By destinationField = By.xpath("//input[@placeholder='Type or choose your destination(s)']");
    private final By nextbtn = By.xpath("//button[normalize-space()='Next']");
    private final By ageField = By.xpath("//input[contains(@placeholder,'DD/MM/YYYY')]");
    private final By getQuoteButton = By.cssSelector("button[type='submit'], button[class*='quote'], button[class*='search']");
    private final By errorMessage = By.cssSelector("[class*='error'], [role='alert']");
    private final By quoteResults = By.cssSelector("[class*='result'], [class*='plan'], [class*='policy']");
    private final By statedropdown = By.xpath("//input[@id='headlessui-combobox-input-«r2»']");


    public void openQuotePage() {
        navigateTo(ConfigReader.getUrl("destinations.url", "//trip-destinations"));
    }

    public void openusquotepage() {
        navigateTo(ConfigReader.getUrl("usquote.url", "/state-of-residence"));
    }

    public boolean isusquotepagedisplayed() {
        return getCurrentUrl().contains("us/state-of-residence") || getCurrentUrl().contains("quote");
    }

    public void selectStateDropdown(String state) {
        driver.findElement(statedropdown).sendKeys(state);
        By option = By.xpath(String.format("//*[contains(normalize-space(.),'%s')]", state));
        wait.until(ExpectedConditions.visibilityOfElementLocated(option));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void enterDestination(String destination) {
        selectFromSearchDropdown(destinationField, destination);
    }

    public void enterDepartureDate(String date) {
        selectDate(date);
    }

    public void clickOnNext() {
        clickElement(nextbtn);
    }

    public void clickOncheckobox() {
        WebElement checkbox = driver.findElement(By.xpath("//*[@data-sentry-source-file='checkboxSVGIcon.component.tsx']"));
        checkbox.click();
    }


    public void enterReturnDate(String date) {
        selectDate(date);
    }

    public void enterTravellerAge(String age) {
        enterText(ageField, age);
    }

    public void clickGetQuote() {
        clickElement(getQuoteButton);
    }

    public boolean isQuotePageDisplayed() {
        return getCurrentUrl().contains("trip-destinations") || getCurrentUrl().contains("quote");
    }


    public boolean isDestinationFieldDisplayed() {
        return isElementDisplayed(destinationField);
    }

    public boolean isQuoteResultsDisplayed() {
        return isElementDisplayed(quoteResults);
    }

    public boolean isErrorDisplayed() {
        return isElementDisplayed(errorMessage);
    }

}
