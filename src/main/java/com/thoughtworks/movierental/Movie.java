package com.thoughtworks.movierental;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    public static final int BLURAY = 3;
    private int priceCode;
    private String title;
    private Category category;


    public Movie(int priceCode, String title) {
        this.title = title;
        this.priceCode = priceCode;
        this.category = Category.values()[priceCode];
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
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
        return priceCode == Category.NEW_RELEASE.getPriceCode();
    }

    double calculateChargesFor(int dayRented) {
        if (dayRented < category.getAllowanceDays())
            return category.getBaseCharges();

        int days = dayRented - category.getAllowanceDays();
        return category.calculateChargesFor(days);
    }

    public boolean isBluRay() {
        return priceCode == Category.BLURAY.getPriceCode();
    }
}