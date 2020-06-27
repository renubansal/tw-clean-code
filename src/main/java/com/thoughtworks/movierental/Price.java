package com.thoughtworks.movierental;

public interface Price {
    double amount(int rentedDays);
    int frequentRenterPoint(int rentedDays);
}
