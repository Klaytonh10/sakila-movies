package com.pluralsight;

public class Film {

    private int filmID;
    private String title;
    private String description;

    public Film(int filmID, String title, String description) {
        this.filmID = filmID;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFilmID() {
        return filmID;
    }

    public String getDescription() {
        return description;
    }
}
