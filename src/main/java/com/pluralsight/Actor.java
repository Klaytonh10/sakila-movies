package com.pluralsight;

import java.util.ArrayList;

public class Actor {

    private String firstName;
    private String lastName;
    private ArrayList<Movie> movies;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = new ArrayList<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
