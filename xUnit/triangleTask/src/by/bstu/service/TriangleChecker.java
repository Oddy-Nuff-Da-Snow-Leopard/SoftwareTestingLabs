package by.bstu.service;

public class TriangleChecker {

    private TriangleChecker() {
    }

    public static boolean checkSidesForTrianglePossibility(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0
                && a + b > c && a + c > b && b + c > a;
    }
}
