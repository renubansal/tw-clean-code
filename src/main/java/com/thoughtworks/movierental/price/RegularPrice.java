package com.thoughtworks.movierental.price;

public class RegularPrice implements Price {

    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    public static final int BASE_CHARGES = 2;
    public static final double DAYWISE_CHARGE = 1.5;
    public static final int DISCOUNTED_DAYS = 2;

    public double amount(int daysRented) {
        if (daysRented < DISCOUNTED_DAYS)
            return BASE_CHARGES;
        return BASE_CHARGES + (daysRented - DISCOUNTED_DAYS) * DAYWISE_CHARGE;
    }

    @Override
    public int frequentRenterPoint(int rentedDays) {
        return DEFAULT_FREQUENT_RENTER_POINTS;
    }
}
