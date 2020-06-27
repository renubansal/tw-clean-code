package com.thoughtworks.movierental;

public class RegularPrice implements Price {

    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    public double amount(int daysRented) {
        double amount = 0;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        amount += 2;
        return amount;
    }

    @Override
    public int frequentRenterPoint(int rentedDays) {
        return DEFAULT_FREQUENT_RENTER_POINTS;
    }
}
