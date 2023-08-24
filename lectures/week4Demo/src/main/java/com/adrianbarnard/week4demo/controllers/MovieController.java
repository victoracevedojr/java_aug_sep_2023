package com.adrianbarnard.week4demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adrianbarnard.week4demo.models.Movie;
import com.adrianbarnard.week4demo.services.MovieService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/movies") // All routes in this controller will start with "/movies"
public class MovieController {
	@Autowired
	private MovieService movieServ; // No "final" and no constructor needed if we add @Autowired
	
	@GetMapping("/create") // The "movies/create" GET route to show the form for adding a movie
	public String addMovieForm(@ModelAttribute("newMovie") Movie newMovie,
			Model viewModel) { // The ModelAttribute will hold a Movie object (initially empty)
		// Pass along ratings to show in the dropdown in the form
		String[] allRatings = {"G", "PG", "PG-13", "R", "NC-17"};
		viewModel.addAttribute("possibleRatings", allRatings);
		return "createMovie.jsp";
	}
	
	@PostMapping("/new")
	public String addMovieToDatabase(@Valid @ModelAttribute("newMovie") Movie newMovie, BindingResult result) {
		if (result.hasErrors()) { // If there are validation errors...
			return "createMovie.jsp"; // .. rerender the page (technically the post request doesn't complete, so it's okay)
		} else {
			// Talk to the service to add the movie
			movieServ.createMovie(newMovie);
			return "redirect:/movies/all";
		}
	}
	
	@GetMapping("/all")
	public String showAllMovies() {
		return null; // PLACEHOLDER - will build Thursday
	}
}
