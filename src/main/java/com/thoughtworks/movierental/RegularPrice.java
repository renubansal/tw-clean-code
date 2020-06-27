package com.thoughtworks.movierental;

public class RegularPrice {

    public RegularPrice() {
    }

    public double amount(int daysRented) {
        double amount = 0;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        amount += 2;
        return amount;
    }
}
