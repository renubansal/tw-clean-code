package com.thoughtworks.movierental.price;

public class RegularPrice implements Price {

    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    public double amount(int daysRented) {
        if (daysRented < 2)
            return 2;
        return 2 + (daysRented - 2) * 1.5;
    }

    @Override
    public int frequentRenterPoint(int rentedDays) {
        return DEFAULT_FREQUENT_RENTER_POINTS;
    }
}
