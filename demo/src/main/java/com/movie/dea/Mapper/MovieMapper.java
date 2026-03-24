package com.movie.dea.Mapper;

import com.movie.dea.dto.MovieDTO;
import com.movie.dea.dto.MovieForm;
import com.movie.dea.entity.Director;
import com.movie.dea.entity.Movie;
import org.springframework.stereotype.Component;

    @Component
    public class MovieMapper {

        public MovieDTO toDTO(Movie movie){
            MovieDTO dto = new MovieDTO();
            dto.setId(movie.getId());
            dto.setTitle(movie.getTitle());
            dto.setGenre(movie.getGenre());
            dto.setDuration(movie.getDuration());
            dto.setReleaseDate(movie.getReleaseDate());

            if (movie.getDirector() != null){
                dto.setDirectorId(movie.getDirector().getId());
                dto.setDirectorName(movie.getDirector().getName());
            }
            return dto;
        }

        public MovieForm toForm(Movie movie){
            MovieForm form = new MovieForm();
            form.setId(movie.getId());
            form.setTitle(movie.getTitle());
            form.setGenre(movie.getGenre());
            form.setDuration(movie.getDuration());
            form.setReleaseDate(movie.getReleaseDate());

            if (movie.getDirector() != null){
                form.setDirectorId(movie.getDirector().getId());
            }
            return form;
        }

        public void updatedEntityForm(MovieForm form, Movie movie, Director director){
            movie.setTitle(form.getTitle());
            movie.setGenre(form.getGenre());
            movie.setDuration(form.getDuration());
            movie.setReleaseDate(form.getReleaseDate());
            movie.setDirector(director);
        }
    }