package com.thoughtworks.movierental;

public class Movie {

    private int id;
    private String title;
    private Category category;

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    public static final int BLURAY = 3;


    public Movie(int id, String title) {
        this.title = title;
        this.id = id;
        this.category = Category.values()[id];
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
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

    public boolean isBluRay() {
        return id == Category.BLURAY.getPriceCode();
    }
}