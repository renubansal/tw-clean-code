package com.thoughtworks.movierental.price;

public interface Price {
    double amount(int rentedDays);
    int frequentRenterPoint(int rentedDays);
}
