package com.thoughtworks.movierental;

public class Customer {
    private final Rentals rentals = new Rentals();
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        return new TextStatement(this.name, rentals)
                .generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(this.name, rentals)
                .generate();
    }
}

