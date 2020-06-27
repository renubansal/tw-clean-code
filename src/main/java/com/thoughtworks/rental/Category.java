package com.thoughtworks.rental;

//breaks single responnsibility principle
public enum Category {
    REGULAR(0, 2, 2, 1.5),
    NEW_RELEASE(1, 0, 0, 3),
    CHILDRENS(2, 3, 1.5, 1.5),
    BLURAY(3, 0, 0, 4);

    private final int movieId;
    private final double baseCharges;
    private final int allowanceDays;
    private final double charge;

    Category(int movieId, int allowanceDays, double baseCharges, double charge) {
        this.movieId = movieId;
        this.baseCharges = baseCharges;
        this.allowanceDays = allowanceDays;
        this.charge = charge;
    }

    public int getPriceCode() {
        return movieId;
    }

    public int getAllowanceDays() {
        return allowanceDays;
    }

    public double getBaseCharges() {
        return baseCharges;
    }

    double calculateChargesFor(int days) {
        return baseCharges + (days) * charge;
    }
}