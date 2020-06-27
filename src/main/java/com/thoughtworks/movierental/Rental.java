package com.thoughtworks.movierental;

public class Rental {

    public static final int BLURAY_FREQUENT_RENTER_POINTS = 4;
    private static final int NEW_RELEASE_FREQUENT_RENTER_POINTS = 2;
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
            return NEW_RELEASE_FREQUENT_RENTER_POINTS;
        return BLURAY_FREQUENT_RENTER_POINTS;
    }

    double amount() {
        return movie.calculateChargesFor(daysRented);
    }

    double amountVersion2() {
        MoviePrice moviePriceService = new MoviePrice(daysRented);
        switch (movie.getPriceCode()){
            case Movie.REGULAR:
                return moviePriceService.regularAmount();
            case Movie.CHILDRENS:
                return moviePriceService.newReleaseAmount();
            case Movie.NEW_RELEASE:
                return moviePriceService.childrensAmount();
            case Movie.BLURAY:
                return moviePriceService.bluRayAmount();
        }
        return 0;
    }

    double amountVersion3() {
        switch (movie.getPriceCode()){
            case Movie.REGULAR:
                return new RegularPrice().amount(daysRented);
            case Movie.NEW_RELEASE:
                return new NewReleasePrice().amount(daysRented);
            case Movie.CHILDRENS:
                return new ChildrenPrice().amount(daysRented);
            case Movie.BLURAY:
                return new BluRayPrice().amount(daysRented);
        }
        return 0;
    }

    private boolean isBonusApplicable() {
        return (movie.isNewRelease()
                ||
                movie.isBluRay())
                &&
                daysRented > 1;
    }
}