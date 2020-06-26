package com.thoughtworks.movierental;

public class Movie {

    private String title;
    private int priceCode;
    private MovieType type;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        this.type = MovieType.values()[priceCode];
    }

    public String getTitle() {
        return title;
    }

    boolean isNewRelease() {
        return priceCode == MovieType.NEW_RELEASE.getPriceCode();
    }

    double calculateCharge(int dayRented) {
        if(dayRented < type.getNormalDayCount())
            return type.getNormalDayCharges();
        return type.getNormalDayCharges() + (dayRented - type.getNormalDayCount()) * type.getExtendedDayCharges();
    }
}