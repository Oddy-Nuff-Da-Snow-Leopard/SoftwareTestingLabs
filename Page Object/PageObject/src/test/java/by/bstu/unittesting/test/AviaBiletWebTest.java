package by.bstu.unittesting.test;

import by.bstu.unittesting.page.BookingPage;
import by.bstu.unittesting.page.FlightSelectionPage;
import by.bstu.unittesting.page.MainPage;
import by.bstu.unittesting.page.PaymentPage;
import by.bstu.unittesting.page.RuleConfirmationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

public class AviaBiletWebTest {

    private static final String NEXT_DAY_OF_MONTH
            = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);

    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver",
                "/Frameworks/Selenium WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBookingTicketWithoutIndicatingPassportData() {

        MainPage mainPage = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .typeOrigin("Москва")
                .typeDestination("Санкт-Петербург")
                .typeDepartureDate(NEXT_DAY_OF_MONTH)
                .clickSearchButton();

        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver)
                .selectFlight();

        BookingPage bookingPage = new BookingPage(driver)
                .typeEmail("angry.school.boy@mail.ru")
                .typePassword("Etg1ejAt")
                .clickLoginButton()
                .selectGender()
                .typeSurname("Conor")
                .typeName("John")
                .typeDateOfBirth("01", "01", "2000")
                .typePassportExpire("01", "01", "2022")
                .clickBookTicketButton();

        assertTrue(bookingPage.getErrorText().equals("Это поле необходимо заполнить"));
    }

    @Test
    public void testEnteringWrongCardNumberWhenPaying() throws InterruptedException {

        MainPage mainPage = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .typeOrigin("Москва")
                .typeDestination("Санкт-Петербург")
                .typeDepartureDate(NEXT_DAY_OF_MONTH)
                .clickSearchButton();

        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver)
                .selectFlight();

        BookingPage bookingPage = new BookingPage(driver)
                .typeEmail("angry.school.boy@mail.ru")
                .typePassword("Etg1ejAt")
                .clickLoginButton()
                .selectGender()
                .typeSurname("Conor")
                .typeName("John")
                .typeDateOfBirth("01", "01", "2000")
                .typePassportData("Hubabuba")
                .typePassportExpire("01", "01", "2022")
                .clickBookTicketButton();

        RuleConfirmationPage ruleConfirmationPage = new RuleConfirmationPage(driver)
                .confirmRules()
                .clickPayButton();

        PaymentPage paymentPage = new PaymentPage(driver)
                .typeCardNumber("1337 1488 1337 1488")
                .typeCardExpire("06", "24")
                .typeCardOwner("Conor McGregor")
                .typeCVVCode("228")
                .clickPayButton();

        assertTrue(paymentPage.getErrorText().equals("Введите корректные данные."));
    }

    @After
    public void after() {
        driver.close();
    }
}
