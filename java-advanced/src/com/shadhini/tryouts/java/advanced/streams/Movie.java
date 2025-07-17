package com.shadhini.tryouts.java.advanced.streams;

public class Movie implements Comparable<Movie> {

    private String title;
    private int likes;
    private Genre genre;

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    public Movie(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.title);
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }
}
