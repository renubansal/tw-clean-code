package com.thoughtworks.movierental;

public class Movie {

    private int id;
    private String title;
    private Category category;

    public Movie(int id, String title) {
        this.title = title;
        this.id = id;
        this.category = Category.values()[id];
    }

    public String getTitle() {
        return title;
    }

    boolean isNewRelease() {
        return id == Category.NEW_RELEASE.getPriceCode();
    }

    double calculateChargesFor(int dayRented) {
        if(dayRented < category.getAllowanceDays())
            return category.getBaseCharges();

        int days = dayRented - category.getAllowanceDays();
        return category.calculateChargesFor(days);
    }

}