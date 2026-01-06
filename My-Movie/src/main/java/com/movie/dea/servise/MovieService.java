package com.movie.dea.servise;

import com.movie.dea.entity.Movie;
import com.movie.dea.repository.MovieRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    // Удалены дублирующиеся объявления методов и аннотации @PathVariable,
    // которые не должны быть в Service-слое.
    public List<Movie> getAllMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> getAllMovieByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    // Предполагая, что в MovieRepository есть метод для поиска по минимальному рейтингу
    public List<Movie> getAllMovieByMinRating(Double minRating) {
        return movieRepository.findByRatingGreaterThanEqual(minRating); // Изменено на более подходящее имя метода
    }

    public List<Movie> getAllMovieByReleaseDate(LocalDate releaseDate){
        return movieRepository.findByReleaseDate(releaseDate);
    }

    public Movie createMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No such a movie in db: " + id));
    }


    public Page<Movie> getMoviesByPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return movieRepository.findAll(pageable);
    }

    public Movie updateMovie(Integer id, Movie updatedMovie) {
        return movieRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updatedMovie.getTitle());
                    existing.setGenre(updatedMovie.getGenre());
                    existing.setDuration(updatedMovie.getDuration());
                    existing.setDuration(updatedMovie.getRating());
                    existing.setGenre(updatedMovie.getReleaseDate());
                    return movieRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("No such a movie with following ID:" + id));
    }

    public String deleteById(Integer id) {
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return "Movie deleted!";
        }
        return "Not found";
    }
}