package com.thoughtworks.movierental;

public enum PriceInfo {
    REGULAR(0,2, 2, 1.5),
    NEW_RELEASE(1,0, 0, 3),
    CHILDRENS(2,1.5, 3, 1.5),
    BLURAY(3, 0, 0, 4);


    private final int movieCode;
    private final double baseCharge;
    private final int allowanceDays;
    private final double charge;

    PriceInfo(int movieCode, double baseCharge, int allowanceDays, double charge) {
        this.movieCode = movieCode;
        this.baseCharge = baseCharge;
        this.allowanceDays = allowanceDays;
        this.charge = charge;
    }

    public int getPriceCode() {
        return movieCode;
    }

    public int getAllowanceDays() {
        return allowanceDays;
    }

    public double getBaseCharge() {
        return baseCharge;
    }

    double calculateChargesFor(int days) {
        return baseCharge + (days) * charge;
    }
}