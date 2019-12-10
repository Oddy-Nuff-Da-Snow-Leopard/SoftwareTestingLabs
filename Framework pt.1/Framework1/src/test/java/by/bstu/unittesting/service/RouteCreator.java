package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Route;

public class RouteCreator {

    public static final String TESTDATA_ROUTE_ORIGIN = "testdata.route.origin";
    public static final String TESTDATA_ROUTE_DESTINATION = "testdata.route.destination";
    public static final String TESTDATA_ROUTE_DEPARTURE_DAY = "route.departureDay";

    public static Route createRouteWithAllFieldsFromProperty() {
        return new Route(TestDataReader.getTestData(TESTDATA_ROUTE_ORIGIN),
                TestDataReader.getTestData(TESTDATA_ROUTE_DESTINATION),
                TestDataReader.getTestData(TESTDATA_ROUTE_DEPARTURE_DAY));
    }
}
