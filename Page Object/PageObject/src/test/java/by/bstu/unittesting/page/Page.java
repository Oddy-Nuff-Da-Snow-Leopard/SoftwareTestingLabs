package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    private static final int SECONDS_TO_LOAD = 30;

    protected WebDriver driver;

    private Page() {
    }

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitUntilElementToBeClickable(By locator) {
        new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions
                        .elementToBeClickable(locator));
    }

    protected void waitUntilPresenceOfElement(By locator) {
        new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
