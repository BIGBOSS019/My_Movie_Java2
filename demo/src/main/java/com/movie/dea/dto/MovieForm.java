package com.movie.dea.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
    public class MovieForm {
        private Integer id;
        @NotBlank(message ="Title required")
        @Size(min = 8 ,max = 50, message = "The limit has been exceeded, min 8, max 50")
        private String title;
        private Double rating;
        @NotNull(message ="ReleaseDate required")
        private LocalDate releaseDate;
        @Size(min = 2,max = 3, message = "The limit has been exceeded, min 2, max 3")
        @NotBlank(message ="Duration required")
        private String duration;

        @NotBlank(message ="Genre required")
        @Size(min = 5 ,max = 20, message = "The limit has been exceeded, min 5, max 20")
        private String genre;

        @NotNull(message = "Shouldn't be null!")
        private Integer directorId;
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

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public LocalDate getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public Integer getDirectorId() {
            return directorId;
        }

        public void setDirectorId(Integer directorId) {
            this.directorId = directorId;
        }

        public Double getRating() {return rating;}

        public void setRating(Double rating) {this.rating=rating;}
}