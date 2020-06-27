package com.thoughtworks.movierental;

//break single responsibility principle
public class MoviePrice {
    private final int daysRented;

    public MoviePrice(int daysRented) {
        this.daysRented = daysRented;
    }

    public double newReleaseAmount() {
        return daysRented * 3;
    }

    public double regularAmount() {
        if (daysRented < 2)
            return 1.5;
        return 1.5 +  (daysRented - 2) * 1.5;
    }

    public double childrensAmount() {
        if (daysRented < 3)
            return 1.5;
        return 1.5 + (daysRented - 3) * 1.5;
    }

    public double bluRayAmount() {
        return daysRented * 4;
    }
}