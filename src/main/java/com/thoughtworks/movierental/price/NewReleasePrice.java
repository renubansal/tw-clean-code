package com.thoughtworks.movierental.price;

public class NewReleasePrice implements Price {

    private static final int BONUS_FREQUENT_RENTER_POINTS = 2;
    private static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;
    public static final int CHARGES = 3;

    public double amount(int daysRented) {
        return daysRented * CHARGES;
    }

    @Override
    public int frequentRenterPoint(int rentedDays) {
        if(rentedDays > 1)
            return BONUS_FREQUENT_RENTER_POINTS;
        return DEFAULT_FREQUENT_RENTER_POINTS;
    }
}
