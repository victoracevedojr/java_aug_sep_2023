package com.adrianbarnard.week6demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrianbarnard.week6demo.models.Movie;
import com.adrianbarnard.week6demo.models.Performer;
import com.adrianbarnard.week6demo.services.MovieService;
import com.adrianbarnard.week6demo.services.PerformerService;

import jakarta.validation.Valid;

@Controller
public class PerformerController {
	@Autowired
	private PerformerService performerServ;
	@Autowired
	private MovieService movieServ;
	
	@GetMapping("/performers/new")
	public String newPerformerForm(@ModelAttribute("newPerformer") Performer newPerformer) {
		return "createPerformer.jsp";
	}
	
	@PostMapping("/performers/new")
	public String addPerformerToDB(@Valid @ModelAttribute("newPerformer") Performer newPerformer, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "createPerformer.jsp";
		} else {
			performerServ.createPerformer(newPerformer);
			return "redirect:/performers/all";
		}
	}
	
	@GetMapping("/performers/all")
	public String viewAllPerformers(Model viewModel) {
		viewModel.addAttribute("allPerformers", performerServ.readAllPerformers());
		return "allPerformers.jsp";
	}
	
	@GetMapping("/performers/{id}/view")
	public String viewOnePerformerPage(@PathVariable Long id, Model viewModel) {
		Performer thisPerformer = performerServ.getOnePerformer(id); // Get this performer
		// Grab movies NOT linked to this performer via the movie service
		List<Movie> allAvailableMovies = movieServ.findMoviesWithoutPerformer(thisPerformer);
		viewModel.addAttribute("thisPerformer", thisPerformer);
		viewModel.addAttribute("allAvailableMovies", allAvailableMovies);
		return "viewPerformer.jsp";
	}
	
	@PostMapping("/performers/{id}/addMovie") // Notice the RequestParam as we're using regular form tags and NOT the <form:form>-type tags
	public String addMovieToPerformer(@RequestParam("movie_id") Long movieId, @PathVariable("id") Long performerId) {
		// Talk to service to link movie and performer by ID
		performerServ.addMovieForPerformer(performerId, movieId);
		return "redirect:/performers/"+performerId+"/view";
	}
}
