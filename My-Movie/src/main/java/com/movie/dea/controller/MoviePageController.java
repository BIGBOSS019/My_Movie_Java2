package com.movie.dea.controller;

import com.movie.dea.entity.Movie;
import com.movie.dea.servise.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    // формат добавления
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/new";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Movie movie,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "movies/new";
        }

        movieService.createMovie(movie);
        return "redirect:/movies";
    }

    // формат обновлении
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("movie", movieService.getMovie(id));
        return "movies/edit";
    }

//    @GetMapping("/all")
//    public List<Movie> getMovies(){
//        return movieService.getAllMovie();
//    }

    }

