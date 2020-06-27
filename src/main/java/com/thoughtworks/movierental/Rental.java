package com.thoughtworks.movierental;

public class Rental {
    Movie movie;

    public Rental(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

}