package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage extends Page {

    private static final By EMAIL_INPUT_LOCATION = By.id("email");
    private static final By PASSWORD_INPUT_LOCATION = By.id("password");
    private static final By LOGIN_BUTTON_LOCATION = By.className("js-booking-login-form-btn");

    private static final By GENDER_LABEL_LOCATION = By.className("js-gender-tab-0");

    private static final By SURNAME_INPUT_LOCATION = By.id("lastname_0");
    private static final By NAME_INPUT_LOCATION = By.id("firstname_0");

    private static final By DAY_OF_BIRTH_INPUT_LOCATION = By.id("birthday_day_0");
    private static final By MONTH_OF_BIRTH_INPUT_LOCATION = By.id("birthday_month_0");
    private static final By YEAR_OF_BIRTH_INPUT_LOCATION = By.id("birthday_year_0");

    private static final By PASSPORT_DATA_INPUT_LOCATION = By.id("docnum_0");

    private static final By DAY_OF_PASSPORT_EXPIRE_INPUT_LOCATION = By.id("doc_expire_date_day_0");
    private static final By MONTH_OF_PASSPORT_EXPIRE_INPUT_LOCATION = By.id("doc_expire_date_month_0");
    private static final By YEAR_OF_PASSPORT_EXPIRE_INPUT_LOCATION = By.id("doc_expire_date_year_0");

    private static final By BOOK_TICKET_BUTTON_LOCATION = By.className("js-pre-book-button");

    private static final By ERROR_FIELD_LOCATION = By.cssSelector("samp.error");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public BookingPage typeEmail(String email) {
        waitUntilPresenceOfElement(EMAIL_INPUT_LOCATION).sendKeys(email);
        return this;
    }

    public BookingPage typePassword(String password) {
        waitUntilPresenceOfElement(PASSWORD_INPUT_LOCATION).sendKeys(password);
        return this;
    }

    public BookingPage clickLoginButton() {
        waitUntilElementToBeClickable(LOGIN_BUTTON_LOCATION).click();
        return this;
    }

    public BookingPage selectGender() {
        waitUntilElementToBeClickable(GENDER_LABEL_LOCATION).click();
        return this;
    }

    public BookingPage typeSurname(String surname) {
        driver.findElement(SURNAME_INPUT_LOCATION).sendKeys(surname);
        return this;
    }

    public BookingPage typeName(String name) {
        driver.findElement(NAME_INPUT_LOCATION).sendKeys(name);
        return this;
    }

    public BookingPage typeDateOfBirth(String day, String month, String year) {
        driver.findElement(DAY_OF_BIRTH_INPUT_LOCATION).sendKeys(day);
        driver.findElement(MONTH_OF_BIRTH_INPUT_LOCATION).sendKeys(month);
        driver.findElement(YEAR_OF_BIRTH_INPUT_LOCATION).sendKeys(year);
        return this;
    }

    public BookingPage typePassportData(String passportData) {
        driver.findElement(PASSPORT_DATA_INPUT_LOCATION).sendKeys(passportData);
        return this;
    }

    public BookingPage typePassportExpire(String day, String month, String year) {
        driver.findElement(DAY_OF_PASSPORT_EXPIRE_INPUT_LOCATION).sendKeys(day);
        driver.findElement(MONTH_OF_PASSPORT_EXPIRE_INPUT_LOCATION).sendKeys(month);
        driver.findElement(YEAR_OF_PASSPORT_EXPIRE_INPUT_LOCATION).sendKeys(year);
        return this;
    }

    public BookingPage clickBookTicketButton() {
        waitUntilElementToBeClickable(BOOK_TICKET_BUTTON_LOCATION).click();
        return this;
    }

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }
}
