package com.ferdynan.cinemareserve.persistence.entity.impl;

import com.ferdynan.cinemareserve.persistence.entity.AgeCategory;

import java.time.Duration;

public class Film {

    private final String nameFilm ;

    private final Duration duration;

    private final AgeCategory ageCategory;

    private String genre;

    private final String countryOfOrigin;

    public Film(String nameFilm, Duration duration, AgeCategory ageCategory, String genre, String countryOfOrigin) {
        this.nameFilm = nameFilm;
        this.duration = duration;
        this.ageCategory = ageCategory;
        this.genre = genre;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public Duration getDuration() {
        return duration;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @Override
    public String toString() {
        return "Film{" +
                "nameFilm='" + nameFilm + '\'' +
                ", duration=" + duration +
                ", ageCategory=" + ageCategory +
                ", genre='" + genre + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                '}';
    }
}

