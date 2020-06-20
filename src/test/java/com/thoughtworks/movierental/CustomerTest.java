package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void test(){
        Customer customer = new Customer("Ray");

        Movie deadpoolMovie = new Movie("Deadpool", 1);
        Movie avengersMovie = new Movie("Avengers", 0);
        Movie homeAloneMovie = new Movie("Home Alone", 2);

        customer.addRental(new Rental(deadpoolMovie, 4));
        customer.addRental(new Rental(avengersMovie, 2));
        customer.addRental(new Rental(homeAloneMovie, 3));

        String actualStatement = customer.statement();
        String expectedString = getExpectedString();

        assertEquals(expectedString, actualStatement);
    }

    private String getExpectedString() {
        return "Rental Record for Ray\n" +
                "\tDeadpool\t12.0\n" +
                "\tAvengers\t2.0\n" +
                "\tMalgudi Days\t1.5\n" +
                "Amount owed is 15.5\n" +
                "You earned 4 frequent renter points";
    }

}