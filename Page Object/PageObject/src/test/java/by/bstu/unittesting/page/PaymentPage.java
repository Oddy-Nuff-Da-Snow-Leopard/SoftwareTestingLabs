package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends Page {

    private static final By CARD_NUMBER_INPUT1_LOCATION = By.id("post_card_number_1");
    private static final By CARD_NUMBER_INPUT2_LOCATION = By.id("post_card_number_2");
    private static final By CARD_NUMBER_INPUT3_LOCATION = By.id("post_card_number_3");
    private static final By CARD_NUMBER_INPUT4_LOCATION = By.id("post_card_number_4");

    private static final By MONTH_OF_CARD_EXPIRE_INPUT_LOCATION = By.id("post_month");
    private static final By YEAR_OF_CARD_EXPIRE_INPUT_LOCATION = By.id("post_year");

    private static final By CARD_OWNER_INPUT_LOCATION = By.id("post_owner");
    private static final By CVV_CODE_INPUT_LOCATION = By.id("post_cvv");

    private static final By PAY_BUTTON_LOCATION = By.id("make_payment");

    private static final By ERROR_FIELD_LOCATION
            = By.cssSelector("div.errors:nth-child(4) > span:nth-child(1)");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage typeCardNumber(String cardNumber) {
        waitUntilPresenceOfElement(CARD_NUMBER_INPUT1_LOCATION);
        String[] cardNumberParts = cardNumber.split(" ");
        driver.findElement(CARD_NUMBER_INPUT1_LOCATION).sendKeys(cardNumberParts[0]);
        driver.findElement(CARD_NUMBER_INPUT2_LOCATION).sendKeys(cardNumberParts[1]);
        driver.findElement(CARD_NUMBER_INPUT3_LOCATION).sendKeys(cardNumberParts[2]);
        driver.findElement(CARD_NUMBER_INPUT4_LOCATION).sendKeys(cardNumberParts[3]);
        return this;
    }

    public PaymentPage typeCardExpire(String month, String year) {
        driver.findElement(MONTH_OF_CARD_EXPIRE_INPUT_LOCATION).sendKeys(month);
        driver.findElement(YEAR_OF_CARD_EXPIRE_INPUT_LOCATION).sendKeys(year);
        return this;
    }

    public PaymentPage typeCardOwner(String cardOwner) {
        driver.findElement(CARD_OWNER_INPUT_LOCATION).sendKeys(cardOwner);
        return this;
    }

    public PaymentPage typeCVVCode(String cvvCode) {
        driver.findElement(CVV_CODE_INPUT_LOCATION).sendKeys(cvvCode);
        return this;
    }

    public PaymentPage clickPayButton() {
        waitUntilElementToBeClickable(PAY_BUTTON_LOCATION).click();
        return this;
    }

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }
}
