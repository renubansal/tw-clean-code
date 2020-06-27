package com.thoughtworks.movierental;

import java.util.List;

public class RentalUtils {

    static double totalAmount(List<Rental> rentals) {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            Movie movie = rental.getMovie();
            totalAmount += movie.amount();
        }
        return totalAmount;
    }

    static int totalFrequentRenterPoints(List<Rental> rentals) {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            Movie movie = rental.getMovie();
            totalFrequentRenterPoints += movie.frequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }
}