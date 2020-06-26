package com.thoughtworks.movierental;

public class Movie {

    private String title;
    private int priceCode;
    private PriceInfo moviePriceInfo;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        this.moviePriceInfo = PriceInfo.values()[priceCode];
    }

    public String getTitle() {
        return title;
    }

    boolean isNewRelease() {
        return priceCode == PriceInfo.NEW_RELEASE.getPriceCode();
    }

    double calculateChargesFor(int dayRented) {
        if(dayRented < moviePriceInfo.getAllowanceDays())
            return moviePriceInfo.getBaseCharge();

        int extraDays = dayRented - moviePriceInfo.getAllowanceDays();
        return moviePriceInfo.calculateChargesFor(extraDays);
    }

}