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
        double amount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }
        return amount;
    }

    private boolean isBonusApplicable() {
    return movie.isNewRelease()
            &&
            daysRented > 1;
  }
}