package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldGetPrintStatement() {
        Customer customer = new Customer("Ray");

        Movie deadpoolMovie = new Movie("Deadpool", 1, 4);
        Movie avengersMovie = new Movie("Avengers", 0, 2);
        Movie homeAloneMovie = new Movie("Home Alone", 2,3 );

        customer.addRental(new Rental(deadpoolMovie));
        customer.addRental(new Rental(avengersMovie));
        customer.addRental(new Rental(homeAloneMovie));

        String actualStatement = customer.statement();
        String expectedString = getExpectedString();

        assertEquals(expectedString, actualStatement);
    }

    @Test
    public void shouldGetPrintHtmlStatement() {
        Customer customer = new Customer("Ray");

        Movie deadpoolMovie = new Movie("Deadpool", 1, 4);
        Movie avengersMovie = new Movie("Avengers", 0, 2);
        Movie homeAloneMovie = new Movie("Home Alone", 2, 3);

        customer.addRental(new Rental(deadpoolMovie));
        customer.addRental(new Rental(avengersMovie));
        customer.addRental(new Rental(homeAloneMovie));

        String actualStatement = customer.htmlStatement();
        String expectedString = getExpectedHtmlStatement();

        assertEquals(expectedString, actualStatement);
    }

    private String getExpectedString() {
        return "Rental Record for Ray\n" +
                "\tDeadpool\t12.0\n" +
                "\tAvengers\t2.0\n" +
                "\tHome Alone\t1.5\n" +
                "Amount owed is 15.5\n" +
                "You earned 4 frequent renter points";
    }

    private String getExpectedHtmlStatement() {
        return "<h1>Rental Record for <b>Ray</b></h1><br/>" +
                "Deadpool 12.0<br/>" +
                "Avengers 2.0<br/>" +
                "Home Alone 1.5<br/>" +
                "Amount owed is <b>15.5</b><br/>" +
                "You earned <b>4</b> frequent renter points";
    }

}