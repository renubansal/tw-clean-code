package com.thoughtworks.movierental;

public class NewReleasePrice {

    public NewReleasePrice() {
    }

    public double amount(int daysRented) {
        return daysRented * 3;
    }
}
