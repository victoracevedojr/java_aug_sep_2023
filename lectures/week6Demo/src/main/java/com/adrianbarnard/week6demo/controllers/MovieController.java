package com.adrianbarnard.week6demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adrianbarnard.week6demo.models.Movie;
import com.adrianbarnard.week6demo.services.DirectorService;
import com.adrianbarnard.week6demo.services.MovieService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/movies") // All routes in this controller will start with "/movies"
public class MovieController {
	@Autowired
	private MovieService movieServ; // No "final" and no constructor needed if we add @Autowired
	@Autowired
	private DirectorService directorServ;
	
	@GetMapping("/create") // The "movies/create" GET route to show the form for adding a movie
	public String addMovieForm(@ModelAttribute("newMovie") Movie newMovie,
			Model viewModel) { // The ModelAttribute will hold a Movie object (initially empty)
		// Pass along ratings to show in the dropdown in the form
		String[] allRatings = {"G", "PG", "PG-13", "R", "NC-17"};
		viewModel.addAttribute("possibleRatings", allRatings);
		viewModel.addAttribute("allDirectors", directorServ.readAllDirectors());
		return "createMovie.jsp";
	}
	
	@PostMapping("/new")
	public String addMovieToDatabase(@Valid @ModelAttribute("newMovie") Movie newMovie, BindingResult result, Model viewModel) {
		if (result.hasErrors()) { // If there are validation errors...
			/* IMPORTANT: If you passed in any data through your Model, you MUST pass it in again!!! */
			String[] allRatings = {"G", "PG", "PG-13", "R", "NC-17"};
			viewModel.addAttribute("possibleRatings", allRatings);
			return "createMovie.jsp"; // .. rerender the page (technically the post request doesn't complete, so it's okay)
		} else {
			// Talk to the service to add the movie
			movieServ.createMovie(newMovie);
			return "redirect:/movies/all";
		}
	}
	
	@GetMapping("/all")
	public String showAllMovies(Model viewModel) {
		// Talk to the service to grab all movies
		List<Movie> allMovies = movieServ.readAllMovies();
		viewModel.addAttribute("allMovies", allMovies);
		return "allMovies.jsp"; 
	}
	
	@GetMapping("/{id}/view") // Need path variable to specify which movie we want by ID
	public String showOneMovie(@PathVariable("id") Long id, Model viewModel) {
		// Grab a movie by ID via our service
		Movie foundMovie = movieServ.getOneMovie(id);
		viewModel.addAttribute("thisMovie", foundMovie);
		return "viewMovie.jsp";
	}
	
	@GetMapping("/{id}/edit") // Display the edit form
	public String showEditForm(@PathVariable("id") Long id, Model viewModel) {
		// Grab a movie by ID via our service
		Movie foundMovie = movieServ.getOneMovie(id);
		viewModel.addAttribute("thisMovie", foundMovie);
		// Must display ratings for our form so we can pick
		String[] allRatings = {"G", "PG", "PG-13", "R", "NC-17"};
		viewModel.addAttribute("possibleRatings", allRatings);
		viewModel.addAttribute("allDirectors", directorServ.readAllDirectors());
		return "editMovie.jsp";
	}
	
	@PutMapping("/{id}/update")
	public String editMovieInDB(@Valid @ModelAttribute("thisMovie") Movie thisMovie, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			// Must pass along ratings again (any model attributes that aren't the original Movie object must be passed along again)
			String[] allRatings = {"G", "PG", "PG-13", "R", "NC-17"};
//			viewModel.addAttribute("thisMovie", thisMovie); // Commented out - not needed
			viewModel.addAttribute("possibleRatings", allRatings);
			return "editMovie.jsp";
		} else {
			Movie editedMovie = movieServ.updateMovie(thisMovie);
			return "redirect:/movies/" + thisMovie.getId() + "/view";
		}
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteMovie(@PathVariable("id") Long id) {
		movieServ.removeMovie(id);
		return "redirect:/movies/all";
	}
}
