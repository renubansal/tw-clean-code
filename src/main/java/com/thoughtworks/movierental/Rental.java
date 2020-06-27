package com.thoughtworks.movierental;

public class Rental {
    private Movie movie;

    public Rental(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    int frequentRenterPoints() {
        return movie.price().frequentRenterPoint(movie.getRentedDays());
    }

    double amount() {
        return movie.price().amount(movie.getRentedDays());
    }

    private boolean isBonusApplicable() {
        return (movie.isNewRelease()
                ||
                movie.isBluRay())
                &&
                movie.getRentedDays() > 1;
    }
}