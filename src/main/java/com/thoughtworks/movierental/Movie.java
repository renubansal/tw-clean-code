package com.thoughtworks.movierental;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    public static final int BLURAY = 3;

    private int priceCode;
    private final int rentedDays;
    private String title;

    public Movie(String title, int priceCode, int rentedDays) {
        this.title = title;
        this.priceCode = priceCode;
        this.rentedDays = rentedDays;
    }

    public String getTitle() {
        return title;
    }

    public int getRentedDays() {
        return rentedDays;
    }

    Price price() {
        switch (priceCode) {
            case Movie.REGULAR:
                return new RegularPrice();
            case Movie.CHILDRENS:
                return new ChildrenPrice();
            case Movie.NEW_RELEASE:
                return new NewReleasePrice();
            case Movie.BLURAY:
                return new BluRayPrice();
            default:
                return null;
        }
    }

    boolean isNewRelease() {
        return priceCode == Movie.NEW_RELEASE;
    }

    public boolean isBluRay() {
        return priceCode == Movie.BLURAY;
    }
}