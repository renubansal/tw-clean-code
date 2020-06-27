package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Ray");

        Movie deadpoolMovie = new Movie("Deadpool", 1, 4);
        Movie avengersMovie = new Movie("Avengers", 0, 2);
        Movie homeAloneMovie = new Movie("Home Alone", 2,3 );
        Movie bluRay = new Movie("Home Alone", 3,3);

        customer.addRental(new Rental(deadpoolMovie));
        customer.addRental(new Rental(avengersMovie));
        customer.addRental(new Rental(homeAloneMovie));
        customer.addRental(new Rental(bluRay));
    }

    @Test
    public void shouldGetPrintStatement() {
        String actualStatement = customer.statement();
        String expectedString = getExpectedString();

        assertEquals(expectedString, actualStatement);
    }

    @Test
    public void shouldGetPrintHtmlStatement() {
        String actualStatement = customer.htmlStatement();
        String expectedString = getExpectedHtmlStatement();

        assertEquals(expectedString, actualStatement);
    }

    private String getExpectedString() {
        return "Rental Record for Ray\n" +
                "\tDeadpool\t12.0\n" +
                "\tAvengers\t2.0\n" +
                "\tHome Alone\t1.5\n" +
                "\tHome Alone\t12.0\n" +
                "Amount owed is 27.5\n" +
                "You earned 8 frequent renter points";
    }

    private String getExpectedHtmlStatement() {
        return "<h1>Rental Record for <b>Ray</b></h1><br/>" +
                "Deadpool 12.0<br/>" +
                "Avengers 2.0<br/>" +
                "Home Alone 1.5<br/>" +
                "Home Alone 12.0<br/>" +
                "Amount owed is <b>27.5</b><br/>" +
                "You earned <b>8</b> frequent renter points";
    }

}