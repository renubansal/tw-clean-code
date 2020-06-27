package com.thoughtworks.movierental;

public class Rental {

    public static final int BLURAY_BONUS_FREQUENT_POINTS = 4;
    private static final int BONUS_FREQUENT_RENTER_POINTS = 2;
    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    int frequentRenterPoints() {
        if (!isBonusApplicable())
            return DEFAULT_FREQUENT_RENTER_POINTS;
        if (movie.isNewRelease())
            return BONUS_FREQUENT_RENTER_POINTS;
        return BLURAY_BONUS_FREQUENT_POINTS;
    }

    double amount() {
        return movie.calculateChargesFor(daysRented);
    }

    private boolean isBonusApplicable() {
        return (movie.isNewRelease()
                ||
                movie.isBluRay())
                &&
                daysRented > 1;
    }
}