package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectionPage extends AbstractPage {
    
    private final Logger logger = LogManager.getRootLogger();
    
    private final By selectButtonLocator = By.className("rec_submit");
    
    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }
    
    public BookingPage selectFlight() {
        WebElement selectButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(selectButtonLocator));
        selectButton.click();
        logger.info("Flight selected");
        return new BookingPage(driver);
    }
}
