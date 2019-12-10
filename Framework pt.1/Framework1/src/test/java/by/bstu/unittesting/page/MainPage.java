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

    private final By searchButtonLocator = By.className("search_button");

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

    public FlightSelectionPage clickSearchButton() {
        WebElement searchButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        logger.info("Search button clicked");
        return new FlightSelectionPage(driver);
    }
}
