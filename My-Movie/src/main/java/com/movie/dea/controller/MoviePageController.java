package com.movie.dea.controller;

import com.movie.dea.entity.Movie;
import com.movie.dea.servise.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/movies")

public class MoviePageController {


        private final MovieService movieService;

        public MoviePageController(MovieService movieService) {
            this.movieService = movieService;
        }

        @GetMapping
        public String list(Model model) {
            model.addAttribute("movies", movieService.getAllMovie());
            return "movies/list";
        }

//    @GetMapping("/all")
//    public List<Movie> getMovies(){
//        return movieService.getAllMovie();
//    }

    }

