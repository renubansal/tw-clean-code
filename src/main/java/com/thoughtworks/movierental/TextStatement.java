package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private final String customerName;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;
    private final List<Rental> rentals;

    public TextStatement(String customerName,
                         double totalAmount,
                         int totalFrequentRenterPoints,
                         List<Rental> rentals) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
        this.rentals = rentals;
    }

    public String statement() {
        return header() + details() + footer();
    }

    String header() {
        return "Rental Record for " + customerName + "\n";
    }

    String details() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.amount()) + "\n";
        }
        return result;
    }

    String footer() {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }
}