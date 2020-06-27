package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldReturnAmountForRegularMovieWhenRentedDayIsEqualToTwo() {
        Movie regularMovie = new Movie("A", 0, 2);
        double actualAmount = regularMovie.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForRegularMovieWhenRentedDayIsGreaterThanTwo() {
        Movie regularMovie = new Movie("A", 0, 10);
        double actualAmount = regularMovie.amount();
        assertEquals(14, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForRegularMovie() {
        Movie regularMovie = new Movie("A", 0, 2);
        double actualAmount = regularMovie.amount();
        assertEquals(2, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForNewReleaseMovie() {
        Movie newReleaseMovie = new Movie("A", 1, 2);
        double actualAmount =newReleaseMovie .amount();
        assertEquals(6, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForBlurayMovie() {
        Movie blurayMovie = new Movie("A", 3, 5);
        double actualAmount = blurayMovie.amount();
        assertEquals(20, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForChildrensWhenRentedDayIsLessThanAndEqualToThree() {
        Movie childrenMovie = new Movie("A", 2, 2);
        double actualAmount = childrenMovie.amount();
        assertEquals(1.5, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnAmountForChildrensWhenRentedDayIsGreaterThanThree() {
        Movie childrenMovie = new Movie("A", 2, 5);
        double actualAmount = childrenMovie.amount();
        assertEquals(4.5, actualAmount, 0.01);
    }

    @Test
    public void shouldReturnTwoBonusPointsIfApplicableForBonus() {
        Movie newReleaseMovie = new Movie("Title", 1, 5);

        assertEquals(2,newReleaseMovie.frequentRenterPoints());
    }

    @Test
    public void shouldReturnOneBonusPointIfApplicableForDefaultBonus() {
        Movie regularMovie = new Movie("Title", 0, 5);

        assertEquals(1,regularMovie.frequentRenterPoints());
    }

    @Test
    public void shouldReturnFrequentReturnPointsForBlurayMovie() {
        Movie blurayMovie = new Movie("A", 3, 5);
        assertEquals(4,blurayMovie.frequentRenterPoints());
    }
}