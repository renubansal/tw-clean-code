package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(this.name, totalAmount(), totalFrequentRenterPoints(), this.rentals).statement();
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";
    }

    private String htmlDetails() {
        String result = "";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() + " " +
                    String.valueOf(rental.amount()) + "<br/>";
        }
        return result;
    }

    private String htmlFooter() {
        String result = "Amount owed is <b>" + totalAmount() + "</b><br/>";
        result += "You earned <b>" + totalFrequentRenterPoints()
                + "</b> frequent renter points";
        return result;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    private int totalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            totalFrequentRenterPoints += rental.frequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

    public String htmlStatement() {
        return htmlHeader() + htmlDetails() + htmlFooter();
    }
}

