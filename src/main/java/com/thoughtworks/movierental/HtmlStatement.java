package com.thoughtworks.movierental;

public class HtmlStatement {

    private final String customerName;
    private final Rentals rentals;

    public HtmlStatement(String customerName,
                         Rentals rentals) {
        this.customerName = customerName;
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
                    rental.movie.amount() + "<br/>";
        }
        return result;
    }

    String footer() {
        String result = "Amount owed is <b>" + rentals.totalAmount() + "</b><br/>";
        result += "You earned <b>" + rentals.totalFrequentRenterPoints()
                + "</b> frequent renter points";
        return result;
    }
}