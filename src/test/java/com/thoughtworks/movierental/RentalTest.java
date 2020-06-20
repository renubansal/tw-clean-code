package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void getTestAmountForRegularWhenRentedDayIsEqualToTwo() {
        Movie regularMovie = new Movie("A", 0);
        Rental rental = new Rental(regularMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void getTestAmountForRegularWhenRentedDayIsGreaterThanTwo() {
        Movie regularMovie = new Movie("A", 0);
        Rental rental = new Rental(regularMovie, 10);
        double actualAmount = rental.amount();
        assertEquals(14, actualAmount, 0.01);
    }

    @Test
    public void getTestAmountForRegular() {
        Movie regularMovie = new Movie("A", 0);
        Rental rental = new Rental(regularMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void getTestAmountForNewRelease() {
        Movie newReleaseMovie = new Movie("A", 1);
        Rental rental = new Rental(newReleaseMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(6, actualAmount, 0.01);
    }

    @Test
    public void getTestAmountForChildrensWhenRentedDayIsLessThanAndEqualToThree() {
        Movie childrenMovie = new Movie("A", 2);
        Rental rental = new Rental(childrenMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(1.5, actualAmount, 0.01);
    }

    @Test
    public void getTestAmountForChildrensWhenRentedDayIsGreaterThanThree() {
        Movie childrenMovie = new Movie("A", 2);
        Rental rental = new Rental(childrenMovie, 5);
        double actualAmount = rental.amount();
        assertEquals(4.5, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnTwoBonusPointsIfApplicableForBonus() {
        Movie newReleaseMovie = new Movie("Title", 1);
        Rental rental = new Rental(newReleaseMovie, 5);

        assertEquals(2, rental.frequentRenterPoints());
    }

    @Test
    public void shouldReturnOneBonusPointIfApplicableForDefaultBonus() {
        Movie regularMovie = new Movie("Title", 0);
        Rental rental = new Rental(regularMovie, 5);

        assertEquals(1, rental.frequentRenterPoints());
    }
}