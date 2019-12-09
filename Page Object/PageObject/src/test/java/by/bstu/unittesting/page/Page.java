package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected WebElement waitUntilElementToBeClickable(By locator) {
        return new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitUntilPresenceOfElement(By locator) {
        return new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
