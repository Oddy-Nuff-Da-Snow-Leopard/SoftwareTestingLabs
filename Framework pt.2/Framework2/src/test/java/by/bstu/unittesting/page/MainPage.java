package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.bstu.unittesting.model.Route;

public class MainPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private static final String PAGE_URL = "https://avia.bilet.by/";

    private final By oneWayLabelLocator = By.className("flight-complexity__label");

    @FindBy(id = "from_name")
    private WebElement originInput;

    @FindBy(id = "to_name")
    private WebElement destinationInput;

    @FindBy(id = "departure_date")
    private WebElement departureDateInput;

    @FindBy(className = "preson_quant")
    private WebElement passengerQuantityInput;

    @FindBy(className = "plus")
    private WebElement plusButton;

    @FindBy(className = "adults")
    private WebElement adultsQuantityInput;

    private final By searchButtonLocator = By.className("search_button");

    private final By errorFieldLocator = By.cssSelector("samp.error");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public MainPage selectOnewayRadioButton() {
        WebElement oneWayLabel = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(oneWayLabelLocator));
        oneWayLabel.click();
        logger.info("One way radio button selected");
        return this;
    }

    public MainPage fillInRouteInformation(Route route) {
        originInput.clear();
        originInput.sendKeys(route.getOrigin());
        destinationInput.clear();
        destinationInput.sendKeys(route.getDestination());
        departureDateInput.click();
        driver.findElement(By.linkText(route.getDepartureDay())).click();
        logger.info("Route information filled");
        return this;
    }

    public MainPage fillInOrigin(Route route) {
        originInput.clear();
        originInput.sendKeys(route.getOrigin());
        logger.info("Origin field filled");
        return this;
    }

    public MainPage fillInDestination(Route route) {
        destinationInput.clear();
        destinationInput.sendKeys(route.getDestination());
        logger.info("Destination field filled");
        return this;
    }

    public boolean isDateOnCalendarClickable(Route route) {
        return driver.findElement(By.linkText(route.getDepartureDay())).isSelected();
    }

    public MainPage clickPassengerQuantityInput() {
        passengerQuantityInput.click();
        logger.info("Passenger quantity input clicked");
        return this;
    }

    public MainPage addAdults(int quantity) {
        for (int i = 1; i <= quantity; i++) {
            plusButton.click();
        }
        logger.info(quantity + " adults added");
        return this;
    }

    public String getAdultsQuantity() {
        return adultsQuantityInput.getText();
    }

    public FlightSelectionPage clickSearchButton() {
        WebElement searchButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        logger.info("Search button clicked");
        return new FlightSelectionPage(driver);
    }

    public MainPage clickSearchButtonWithoutGoingToNextPage() {
        WebElement searchButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        logger.info("Search button clicked");
        return this;
    }

    public String getErrorText() {
        WebElement errorField = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(errorFieldLocator));
        return errorField.getText();
    }
}
