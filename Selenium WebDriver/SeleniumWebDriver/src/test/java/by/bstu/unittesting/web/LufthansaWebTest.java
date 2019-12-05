package by.bstu.unittesting.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LufthansaWebTest {

    private static final int SECONDS_TO_LOAD = 15;

    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:/Frameworks/Selenium browsers drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lufthansa.com/");
    }

    @Test
    public void testSameDepartureAndDestinationPoints() {
        driver.get("https://www.lufthansa.com/");

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.id("cm-selectSpecific")));
        driver.findElement(By.id("cm-selectSpecific")).click();

        driver.findElement(By.id("dcep-ae101ece5-7824-4161-bfb1-714621b8e1aa-flm-flight-flightQuery.flightSegments[0].originCode")).sendKeys("Minsk");
        driver.findElement(By.id("dcep-ae101ece5-7824-4161-bfb1-714621b8e1aa-flm-flight-flightQuery.flightSegments[0].destinationCode")).sendKeys("Minsk");

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.className("btn btn-primary")));
        driver.findElement(By.className("btn btn-primary")).click();

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.visibilityOfElementLocated(By.id("dcep-a84a8287d-af99-4eff-a469-764093a1e561-flm-flight-flightQuery.flightSegments[0].destinationCode-error")));
        assertTrue(driver.findElement(By.id("dcep-a84a8287d-af99-4eff-a469-764093a1e561-flm-flight-flightQuery.flightSegments[0].destinationCode-error")).getText().equals("Пункты отправления и назначения совпадают."));
    }

    @Test
    public void testFindingFlightsForAdultsAndMultipleBabies() {
        driver.get("https://www.lufthansa.com/");

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.id("cm-selectSpecific")));
        driver.findElement(By.id("cm-selectSpecific")).click();

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.className("btn btn-primary")));
        driver.findElement(By.className("btn btn-primary")).click();

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.className("btn btn-secondary mw-100 dropdown-btn")));
        driver.findElement(By.className("btn btn-secondary mw-100 dropdown-btn")).click();

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.className("btn-link mb-0 btn-plus border-left-0 stepper-border-gray")));
        driver.findElement(By.className("btn-link mb-0 btn-plus border-left-0 stepper-border-gray")).click();
        driver.findElement(By.className("btn-link mb-0 btn-plus border-left-0 stepper-border-gray")).click();

        new WebDriverWait(driver, SECONDS_TO_LOAD).until(ExpectedConditions.visibilityOfElementLocated(By.className("highlight")));
        assertTrue(driver.findElement(By.className("highlight")).getText().equals("No. of infants must be less or equal adults"));
    }

    @After
    public void after() {
        driver.close();
    }
}
