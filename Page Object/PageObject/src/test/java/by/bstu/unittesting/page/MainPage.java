package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    private static final String PAGE_URL = "https://avia.bilet.by/";

    private static final By ONEWAY_LABEL_LOCATION = By.className("flight-complexity__label");

    private static final By ORIGIN_INPUT_LOCATION = By.id("from_name");
    private static final By DESTINATION_INPUT_LOCATION = By.id("to_name");
    private static final By DEPARTURE_DATE_INPUT_LOCATION = By.id("departure_date");

    private static final By SEARCH_BUTTON_LOCATION = By.className("search_button");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public MainPage selectOnewayRadioButton() {
        waitUntilElementToBeClickable(ONEWAY_LABEL_LOCATION).click();
        return this;
    }

    public MainPage typeOrigin(String origin) {
        driver.findElement(ORIGIN_INPUT_LOCATION).clear();
        driver.findElement(ORIGIN_INPUT_LOCATION).sendKeys(origin);
        return this;
    }

    public MainPage typeDestination(String destination) {
        driver.findElement(DESTINATION_INPUT_LOCATION).clear();
        driver.findElement(DESTINATION_INPUT_LOCATION).sendKeys(destination);
        return this;
    }

    public MainPage typeDepartureDate(String date) {
        driver.findElement(DEPARTURE_DATE_INPUT_LOCATION).click();
        driver.findElement(By.linkText(date)).click();
        return this;
    }

    public MainPage clickSearchButton() {
        waitUntilElementToBeClickable(SEARCH_BUTTON_LOCATION).click();
        return this;
    }
}
