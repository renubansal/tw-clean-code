package com.thoughtworks.movierental;

public class Rental {

    public static final int BLURAY_FREQUENT_RENTER_POINTS = 4;
    private static final int NEW_RELEASE_FREQUENT_RENTER_POINTS = 2;
    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    private Movie movie;

    public Rental(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    int frequentRenterPoints() {
        return movie.price().frequentRenterPoint(movie.getRentedDays());
//        if (!isBonusApplicable())
//            return DEFAULT_FREQUENT_RENTER_POINTS;
//        if (movie.isNewRelease())
//            return NEW_RELEASE_FREQUENT_RENTER_POINTS;
//        return BLURAY_FREQUENT_RENTER_POINTS;
    }

    double amount() {
        return movie.price().amount(movie.getRentedDays());
    }

    private boolean isBonusApplicable() {
        return (movie.isNewRelease()
                ||
                movie.isBluRay())
                &&
                movie.getRentedDays() > 1;
    }
}