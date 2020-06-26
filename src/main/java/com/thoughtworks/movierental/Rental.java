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
                amount = calculateCharges(2, 2, 1.5);
                break;
            case Movie.NEW_RELEASE:
                amount = calculateCharges(0, 0, 3);
                break;
            case Movie.BLURAY:
                amount = calculateCharges(0, 0, 4);
                break;
            case Movie.CHILDRENS:
                amount = calculateCharges(1.5, 3, 1.5);
                break;
        }
        return amount;
    }

    private double calculateCharges(double baseCharge, int dayAllowance, double charge) {
        if(daysRented < dayAllowance)
            return baseCharge;
        return baseCharge + daysRented - dayAllowance * charge;
    }

    private boolean isBonusApplicable() {
        return movie.isNewRelease()
                &&
                daysRented > 1;
    }
}