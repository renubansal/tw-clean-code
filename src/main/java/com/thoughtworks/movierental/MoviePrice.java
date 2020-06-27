package com.thoughtworks.movierental;

public class MoviePrice {
    private final int daysRented;

    public MoviePrice(int daysRented) {
        this.daysRented = daysRented;
    }

    public double newReleaseAmount() {
        return daysRented * 3;
    }

    public double regularAmount() {
        double amount = 0;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        amount += 1.5;
        return amount;
    }

    public double childrensAmount() {
        double amount = 0;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        amount += 1.5;
        return amount;
    }

    public double bluRayAmount() {
        return daysRented * 4;
    }
}
