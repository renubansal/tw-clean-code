package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            totalAmount += rental.movie.amount();
        }
        return totalAmount;
    }

    public int totalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : this) {
            totalFrequentRenterPoints += rental.movie.frequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }
}