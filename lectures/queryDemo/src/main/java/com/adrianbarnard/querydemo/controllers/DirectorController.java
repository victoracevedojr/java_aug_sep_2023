package com.adrianbarnard.querydemo.controllers;

import java.util.ArrayList;
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

import com.adrianbarnard.querydemo.models.Director;
import com.adrianbarnard.querydemo.services.DirectorService;

import jakarta.validation.Valid;

@Controller // Remember your annotations, especially this one!!
public class DirectorController {
	@Autowired
	private DirectorService directorService;

	// Route to SHOW the new director form
	@GetMapping("/directors/create")
	public String addMovieForm(@ModelAttribute("newDirector") Director newDirector) { 
		// The ModelAttribute will hold a Director object (initially empty)
		return "createDirector.jsp";
	}
	
	// POST route to ADD the new director to the database
	@PostMapping("/directors/new")
	public String addMovieToDatabase(@Valid @ModelAttribute("newDirector") Director newDirector, BindingResult result) {
		if (result.hasErrors()) { // If there are validation errors...
			/* IMPORTANT: If you passed in any data through your Model, you MUST pass it in again!!! */
			return "createDirector.jsp"; // .. rerender the page (technically the post request doesn't complete, so it's okay)
		} else {
			// Talk to the service to add the director
			directorService.createDirector(newDirector);
			return "redirect:/directors/all";
		}
	}
	
	// Route to show (read) all directors
	@GetMapping("/directors/all")
	public String showAllMovies(Model viewModel) {
		// Talk to the service to grab all directors
		List<Director> allDirectors = directorService.readAllDirectors();
		viewModel.addAttribute("allDirectors", allDirectors);
		return "allDirectors.jsp"; 
	}
	
	// Route to show (read) one director - note the path variable
	@GetMapping("/directors/{id}/view") 
	public String showOneMovie(@PathVariable("id") Long id, Model viewModel) {
		Director foundDirector = directorService.getOneDirector(id);
		viewModel.addAttribute("thisDirector", foundDirector);
		return "viewDirector.jsp";
	}
	
	// Route to SHOW the edit director form
	@GetMapping("/directors/{id}/edit")
	public String showEditForm(@PathVariable("id") Long id, Model viewModel) {
		// Grab a director by ID via our service
		Director foundDirector = directorService.getOneDirector(id);
		// IMPORTANT: Whatever the name of the attribute is when you pass the item's info from your
		// database, you MUST use that as your modelAttribute value in the form:form tag AND use that
		// name in the quotes in your ModelAttribute annotation in your PUT route!  In this example,
		// we use "thisDirector", but you can use any variable name you wish.
		viewModel.addAttribute("thisDirector", foundDirector);
		return "editDirector.jsp";
	}
	
	// PUT route to update (edit) the director in the database
	@PutMapping("/directors/{id}/update")
	public String editMovieInDB(@Valid @ModelAttribute("thisDirector") Director thisDirector, BindingResult result) {
		if (result.hasErrors()) {
			/* IMPORTANT: If you passed in any data through your Model, you MUST pass it in again!!! */
			return "editDirector.jsp";
		} else {
			directorService.updateDirector(thisDirector);
			return "redirect:/directors/" + thisDirector.getId() + "/view"; // Note the getter here
		}
	}
	
	// DELETE route to remove a director from the database
	@DeleteMapping("/directors/{id}/delete")
	public String deleteMovie(@PathVariable("id") Long id) {
		directorService.removeDirector(id);
		return "redirect:/directors/all";
	}
	
	// Test route for making sure our special queries work (no rendering data in a JSP file due to time)
	@GetMapping("/directors/test")
	public String getDirectorsFirstAndLastNames() {
		ArrayList<String> directorNames = directorService.getFirstAndLastName();
		for (String currentName : directorNames) {
			System.out.println(currentName);
		}
		directorService.getAllWithMovieCounts();
		return null;
	}
}
