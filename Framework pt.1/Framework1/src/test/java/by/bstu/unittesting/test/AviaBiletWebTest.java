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

public class AviaBiletWebTest extends GeneralConfig {

    private static final String BOOKING_PAGE_ERROR_TEXT = "Это поле необходимо заполнить";
    private static final String PAYMENT_PAGE_ERROR_TEXT = "Введите корректные данные.";

    @Test
    public void testBookingTicketWithoutIndicatingPassportData() {

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
