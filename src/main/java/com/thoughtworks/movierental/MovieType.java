package com.thoughtworks.movierental;

public enum MovieType {
    REGULAR(0,2, 2, 1.5),
    NEW_RELEASE(1,0, 0, 3),
    CHILDRENS(2,1.5, 3, 1.5),
    BLURAY(3, 0, 0, 4);


    private final int movieCode;
    private final double normalDayCharges;
    private final int normalDayCount;
    private final double extendedDayCharges;

    MovieType(int movieCode, double normalDayCharges, int normalDay, double extendedDayCharges) {
        this.movieCode = movieCode;
        this.normalDayCharges = normalDayCharges;
        this.normalDayCount = normalDay;
        this.extendedDayCharges = extendedDayCharges;
    }

    public int getPriceCode() {
        return movieCode;
    }

    public double getNormalDayCharges() {
        return normalDayCharges;
    }

    public int getNormalDayCount() {
        return normalDayCount;
    }

    public double getExtendedDayCharges() {
        return extendedDayCharges;
    }
}