package com.freely.web.pages;


import com.freely.web.utils.ConfigReader;
import com.freely.web.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public String getElementText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void selectFromSearchDropdown(By inputField, String value) {
        driver.findElement(inputField).sendKeys(value);
        By option = By.xpath(String.format("//*[contains(text(),'%s')]", value));
        // Wait for option to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(option));
        // Then wait for it to be clickable and click
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void selectStateDropdown(By inputField, String value) {
        driver.findElement(inputField).sendKeys(value);
        By option = By.xpath(String.format("", value));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


    public void selectDate(String date) {

        String[] parts = date.split("/");
        String day = String.valueOf(Integer.parseInt(parts[0]));
        int month = Integer.parseInt(parts[1]);
        String year = parts[2];

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        String monthName = months[month - 1];
        driver.findElement(By.xpath("//button[contains(@class,'react-calendar__navigation__label')]")).click();
        driver.findElement(By.xpath(String.format("//button[.//abbr[normalize-space()='%s']]", monthName))).click();        // 🔹 Step 4: Select Day
        driver.findElement(By.xpath(String.format("//button[normalize-space()='%s']", day))).click();
    }
}
