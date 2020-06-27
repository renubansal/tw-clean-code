package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void shouldReturnAmountForRegularMovieWhenRentedDayIsEqualToTwo() {
        Movie regularMovie = new Movie("A", 0,2 );
        Rental rental = new Rental(regularMovie);
        double actualAmount = rental.movie.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForRegularMovieWhenRentedDayIsGreaterThanTwo() {
        Movie regularMovie = new Movie("A", 0, 10);
        Rental rental = new Rental(regularMovie);
        double actualAmount = rental.movie.amount();
        assertEquals(14, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForRegularMovie() {
        Movie regularMovie = new Movie("A", 0, 2);
        Rental rental = new Rental(regularMovie);
        double actualAmount = rental.movie.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForNewReleaseMovie() {
        Movie newReleaseMovie = new Movie("A", 1, 2);
        Rental rental = new Rental(newReleaseMovie);
        double actualAmount = rental.movie.amount();
        assertEquals(6, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForBlurayMovie() {
        Movie blurayMovie = new Movie("A", 3, 5);
        Rental rental = new Rental(blurayMovie);
        double actualAmount = rental.movie.amount();
        assertEquals(20, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForChildrensWhenRentedDayIsLessThanAndEqualToThree() {
        Movie childrenMovie = new Movie("A", 2,2 );
        Rental rental = new Rental(childrenMovie);
        double actualAmount = rental.movie.amount();
        assertEquals(1.5, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForChildrensWhenRentedDayIsGreaterThanThree() {
        Movie childrenMovie = new Movie("A", 2, 5);
        Rental rental = new Rental(childrenMovie);
        double actualAmount = rental.movie.amount();
        assertEquals(4.5, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnTwoBonusPointsIfApplicableForBonus() {
        Movie newReleaseMovie = new Movie("Title", 1, 5);
        Rental rental = new Rental(newReleaseMovie);

        assertEquals(2, rental.movie.frequentRenterPoints());
    }

    @Test
    public void shouldReturnOneBonusPointIfApplicableForDefaultBonus() {
        Movie regularMovie = new Movie("Title", 0, 5);
        Rental rental = new Rental(regularMovie);

        assertEquals(1, rental.movie.frequentRenterPoints());
    }

    @Test
    public void shouldReturnFrequentReturnPointsForBlurayMovie() {
        Movie blurayMovie = new Movie("A", 3, 5);
        Rental rental = new Rental(blurayMovie);
        assertEquals(4, rental.movie.frequentRenterPoints());
    }
}