package com.thoughtworks.rental;

import com.thoughtworks.rental.MovieVersion;
import com.thoughtworks.rental.RentalVersion;

import java.util.List;

public class RentalUtils {

    static double totalAmount(List<RentalVersion> rentals) {
        double totalAmount = 0;
        for (RentalVersion rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    static int totalFrequentRenterPoints(List<RentalVersion> rentals) {
        int totalFrequentRenterPoints = 0;
        for (RentalVersion rental : rentals) {
            totalFrequentRenterPoints += rental.frequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }
}