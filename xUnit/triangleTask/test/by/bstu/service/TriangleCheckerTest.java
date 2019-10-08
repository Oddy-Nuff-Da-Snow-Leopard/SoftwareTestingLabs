package by.bstu.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleCheckerTest {

    public TriangleCheckerTest() {
    }

    @Test
    public void testThreeSidesEqualsZero() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(0, 0, 0));
    }

    @Test
    public void testTwoSidesEqualsZero() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(5, 0, 0));
    }

    @Test
    public void testOneSideEqualZero() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(2, 7, 0));
    }

    @Test
    public void testThreeNegativeSides() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(-2, -3, -4));
    }

    @Test
    public void testTwoNegativeSides() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(6, -8, -10));
    }

    public void testOneNegativeSide() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(7, 8, -9));
    }

    @Test
    public void testSumOfTwoSidesLessThanThird() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(8, 3, 2));
    }

    @Test
    public void testSumOfTwoSidesEqualThird() {
        assertFalse(TriangleChecker.checkSidesForTrianglePossibility(5, 11, 6));
    }

    @Test
    public void testSuitableSides() {
        assertTrue(TriangleChecker.checkSidesForTrianglePossibility(5, 7, 10));
    }

    @Test
    public void testSidesThatFormsAnIsoscelesTriangle() {
        assertTrue(TriangleChecker.checkSidesForTrianglePossibility(5, 6, 6));
    }

    @Test
    public void testSidesThatFormsAnEquilateralTriangle() {
        assertTrue(TriangleChecker.checkSidesForTrianglePossibility(9, 9, 9));
    }

    @Test
    public void testAnotherSuitableSides() {
        assertTrue(TriangleChecker.checkSidesForTrianglePossibility(7.6, 10.5, 4.2));
    }
}
