package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {

    private final String customerName;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;
    private final List<Rental> rentals;

    public HtmlStatement(String customerName,
                         double totalAmount,
                         int totalFrequentRenterPoints,
                         List<Rental> rentals) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + details() + footer();
    }

    String header() {
        return "<h1>Rental Record for <b>" + customerName + "</b></h1><br/>";
    }

    String details() {
        String result = "";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() + " " +
                    rental.amount() + "<br/>";
        }
        return result;
    }

    String footer() {
        String result = "Amount owed is <b>" + totalAmount + "</b><br/>";
        result += "You earned <b>" + totalFrequentRenterPoints
                + "</b> frequent renter points";
        return result;
    }
}