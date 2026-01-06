package com.movie.dea.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String genre;

    public Movie(Integer id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDuration() {
        return null;
    }

    public void setDuration(Object duration) {
    }

    public Object getRating() {

        String getReleaseDate;

        return "";
    }

    public String getReleaseDate() {

        return "";
    }
}