package by.bstu.unittesting.test;

import by.bstu.unittesting.model.Card;
import by.bstu.unittesting.model.Passport;
import by.bstu.unittesting.model.Route;
import by.bstu.unittesting.model.User;

import by.bstu.unittesting.page.BookingPage;
import by.bstu.unittesting.page.MainPage;
import by.bstu.unittesting.page.RuleConfirmationPage;

import by.bstu.unittesting.service.CardCreator;
import by.bstu.unittesting.service.PassportCreator;
import by.bstu.unittesting.service.RouteCreator;
import by.bstu.unittesting.service.UserCreator;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertFalse;

public class AviaBiletWebTest extends GeneralConfig {

    private static final String MAIN_PAGE_ERROR_TEXT = "Это поле необходимо заполнить";
    private static final String MAX_NUMBER_OF_ADULTS = "9";
    private static final String FLIGHT_PAGE_ERROR_TEXT
            = "Не найдены варианты перелёта, соответствующие вашим критериям";
    private static final String BOOKING_PAGE_ERROR_TEXT = "Это поле необходимо заполнить";
    private static final String PAYMENT_PAGE_ERROR_TEXT = "Введите корректные данные.";

    @Test
    public void testSearchingWithoutOriginCity() {

        Route testRoute = RouteCreator.createRouteWithOnlyDestinationFieldFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInDestination(testRoute)
                .clickSearchButtonWithoutGoingToNextPage()
                .getErrorText();

        assertThat(errorText, is(equalTo(MAIN_PAGE_ERROR_TEXT)));
    }

    @Test
    public void testSearchingWithoutDestinationCity() {

        Route testRoute = RouteCreator.createRouteWithOnlyOriginFieldFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInOrigin(testRoute)
                .clickSearchButtonWithoutGoingToNextPage()
                .getErrorText();

        assertThat(errorText, is(equalTo(MAIN_PAGE_ERROR_TEXT)));
    }

    @Test
    public void testSearchingWithoutDepartureDate() {

        Route testRoute = RouteCreator.createRouteWithoutDepartureDateFieldFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInOrigin(testRoute)
                .fillInDestination(testRoute)
                .clickSearchButtonWithoutGoingToNextPage()
                .getErrorText();

        assertThat(errorText, is(equalTo(MAIN_PAGE_ERROR_TEXT)));
    }

    @Test
    public void testSearchingWithSameOriginAndDestinationCity() {

        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(FLIGHT_PAGE_ERROR_TEXT)));
    }

    @Test
    public void testSearchingWithDepartureDateYesterday() {

        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();

        MainPage mainPage = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInRouteInformation(testRoute);

        assertFalse(mainPage.isDateOnCalendarClickable(testRoute));
    }

    @Test
    public void testEnteringMaxNumberOfAdults() {

        String adultsQuantity = new MainPage(driver).openPage()
                .clickPassengerQuantityInput()
                .addAdults(9)
                .getAdultsQuantity();

        assertThat(adultsQuantity, is(equalTo(MAX_NUMBER_OF_ADULTS)));
    }

    @Test
    public void testBookingTicketWithoutUserLogging() {

        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        User testUser = UserCreator.createUserWithAllFieldsFromProperty();
        Passport testPassport = PassportCreator.createPassportWithAllFieldsFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .fillInUserInformation(testUser)
                .fillInPassportData(testPassport)
                .clickBookTicketButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(BOOKING_PAGE_ERROR_TEXT)));
    }

    @Test
    public void testBookingTicketWithoutIndicatingPassportData() {

        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        User testUser = UserCreator.createUserWithAllFieldsFromProperty();
        Passport testPassport = PassportCreator.createEmptyPassport();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .login(testUser)
                .fillInUserInformation(testUser)
                .fillInPassportData(testPassport)
                .clickBookTicketButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(BOOKING_PAGE_ERROR_TEXT)));
    }

    @Test
    public void testPayWithoutCardDetails() {

        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        User testUser = UserCreator.createUserWithAllFieldsFromProperty();
        Passport testPassport = PassportCreator.createPassportWithAllFieldsFromProperty();

        BookingPage bookingPage = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .login(testUser)
                .fillInUserInformation(testUser)
                .fillInPassportData(testPassport)
                .clickBookTicketButton();

        String errorText = new RuleConfirmationPage(driver)
                .confirmRules()
                .clickPayButton()
                .clickPayButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(PAYMENT_PAGE_ERROR_TEXT)));
    }

    @Test
    public void testEnteringWrongCardNumberWhenPaying() {

        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        User testUser = UserCreator.createUserWithAllFieldsFromProperty();
        Passport testPassport = PassportCreator.createPassportWithAllFieldsFromProperty();
        Card testCard = CardCreator.createCardWithAllFieldsFromProperty();

        BookingPage bookingPage = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .login(testUser)
                .fillInUserInformation(testUser)
                .fillInPassportData(testPassport)
                .clickBookTicketButton();

        String errorText = new RuleConfirmationPage(driver)
                .confirmRules()
                .clickPayButton()
                .fillInCardInformation(testCard)
                .clickPayButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(PAYMENT_PAGE_ERROR_TEXT)));
    }
}
