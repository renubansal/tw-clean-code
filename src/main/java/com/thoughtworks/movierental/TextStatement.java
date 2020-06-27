package com.thoughtworks.movierental;

public class TextStatement {
    private final String customerName;
    private final Rentals rentals;

    public TextStatement(String customerName,
                         Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + details() + footer();
    }

    String header() {
        return "Rental Record for " + customerName + "\n";
    }

    String details() {
        String result = "";
        for (Rental rental : rentals) {
            Movie movie = rental.getMovie();
            result += "\t" + movie.getTitle() + "\t" +
                    movie.amount() + "\n";
        }
        return result;
    }

    String footer() {
        String result = "Amount owed is " + rentals.totalAmount() + "\n";
        result += "You earned " + rentals.totalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }
}