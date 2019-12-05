package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RuleConfirmationPage extends Page {

    private static final By CONFIRM_LABEL_LOCATION = By.className("confirm-btn_wrapper");

    private static final By PAY_BUTTON_LOCATION = By.className("js-book-button");

    public RuleConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public RuleConfirmationPage confirmRules() {
        waitUntilElementToBeClickable(CONFIRM_LABEL_LOCATION);
        driver.findElement(CONFIRM_LABEL_LOCATION).click();
        return this;
    }

    public RuleConfirmationPage clickPayButton() {
        waitUntilElementToBeClickable(PAY_BUTTON_LOCATION);
        driver.findElement(PAY_BUTTON_LOCATION).click();
        return this;
    }
}
