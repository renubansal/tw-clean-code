package com.thoughtworks.movierental;

public class ChildrenPrice implements Price {

    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    public double amount(int daysRented) {
        double amount = 0;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        amount += 1.5;
        return amount;
    }

    @Override
    public int frequentRenterPoint(int rentedDays) {
        return DEFAULT_FREQUENT_RENTER_POINTS;
    }
}
