package com.freely.web.hooks;

import com.freely.web.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {
        // initialise driver before each scenario
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        // take screenshot if scenario fails
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
        DriverFactory.quitDriver();
    }
}
