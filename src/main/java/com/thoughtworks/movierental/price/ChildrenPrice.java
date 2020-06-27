package com.thoughtworks.movierental.price;

public class ChildrenPrice implements Price {

    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    public double amount(int daysRented) {
        if (daysRented < 3)
            return 1.5;
        return 1.5 + (daysRented - 3) * 1.5;
    }

    @Override
    public int frequentRenterPoint(int rentedDays) {
        return DEFAULT_FREQUENT_RENTER_POINTS;
    }
}
