package com.thoughtworks.movierental.price;

public class ChildrenPrice implements Price {

    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    public static final double BASE_CHARGES = 1.5;
    public static final double DAYWISE_CHARGES = 1.5;
    public static final int DISCOUNTED_DAYS = 3;

    public double amount(int daysRented) {
        if (daysRented < DISCOUNTED_DAYS)
            return BASE_CHARGES;
        return BASE_CHARGES + (daysRented - DISCOUNTED_DAYS) * DAYWISE_CHARGES;
    }

    @Override
    public int frequentRenterPoint(int rentedDays) {
        return DEFAULT_FREQUENT_RENTER_POINTS;
    }
}
