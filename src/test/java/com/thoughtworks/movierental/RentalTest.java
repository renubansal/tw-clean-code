package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void shouldReturnAmountForRegularMovieWhenRentedDayIsEqualToTwo() {
        Movie regularMovie = new Movie(0, "A");
        Rental rental = new Rental(regularMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForRegularMovieWhenRentedDayIsGreaterThanTwo() {
        Movie regularMovie = new Movie(0, "A");
        Rental rental = new Rental(regularMovie, 10);
        double actualAmount = rental.amount();
        assertEquals(14, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForRegularMovie() {
        Movie regularMovie = new Movie(0, "A");
        Rental rental = new Rental(regularMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForNewReleaseMovie() {
        Movie newReleaseMovie = new Movie(1, "A");
        Rental rental = new Rental(newReleaseMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(6, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForBlurayMovie() {
        Movie blurayMovie = new Movie(3, "A");
        Rental rental = new Rental(blurayMovie, 5);
        double actualAmount = rental.amount();
        assertEquals(20, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForChildrensWhenRentedDayIsLessThanAndEqualToThree() {
        Movie childrenMovie = new Movie(2, "A");
        Rental rental = new Rental(childrenMovie, 2);
        double actualAmount = rental.amount();
        assertEquals(1.5, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForChildrensWhenRentedDayIsGreaterThanThree() {
        Movie childrenMovie = new Movie(2, "A");
        Rental rental = new Rental(childrenMovie, 5);
        double actualAmount = rental.amount();
        assertEquals(4.5, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnTwoBonusPointsIfApplicableForBonus() {
        Movie newReleaseMovie = new Movie(1, "Title");
        Rental rental = new Rental(newReleaseMovie, 5);

        assertEquals(2, rental.frequentRenterPoints());
    }

    @Test
    public void shouldReturnOneBonusPointIfApplicableForDefaultBonus() {
        Movie regularMovie = new Movie(0, "Title");
        Rental rental = new Rental(regularMovie, 5);

        assertEquals(1, rental.frequentRenterPoints());
    }
}