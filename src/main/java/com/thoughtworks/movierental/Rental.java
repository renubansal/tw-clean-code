package com.thoughtworks.movierental;

public class Rental {

    private static final int BONUS_FREQUENT_RELEASE_POINTS = 2;
    private static final int DEFAULT_FREQUENT_RELEASE_POINTS = 1;
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    int frequentRenterPoints() {
        return (isBonusApplicable())
                ? BONUS_FREQUENT_RELEASE_POINTS : DEFAULT_FREQUENT_RELEASE_POINTS;
    }

    double amount() {
        return movie.calculateCharge(daysRented);
    }

    private boolean isBonusApplicable() {
        return movie.isNewRelease()
                &&
                daysRented > 1;
    }
}