package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSelectionPage extends Page {

    private static final By SELECT_BUTTON_LOCATION = By.className("rec_submit");

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    public FlightSelectionPage selectFlight() {
        waitUntilElementToBeClickable(SELECT_BUTTON_LOCATION).click();
        return this;
    }
}
