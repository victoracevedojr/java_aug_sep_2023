package com.adrianbarnard.week4demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrianbarnard.week4demo.models.Movie;
import com.adrianbarnard.week4demo.repositories.MovieRepository;

@Service // Don't forget your annotations!!!
public class MovieService {
	private final MovieRepository movieRepository; // Injecting our repository
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	// Create a movie
	public Movie createMovie(Movie newMovie) {
		return movieRepository.save(newMovie);
	}
	
	// Read all movies
	public List<Movie> readAllMovies() {
		return movieRepository.findAll();
	}
	
	// Find by title
	public List<Movie> findAllByTitle(String title) {
		return movieRepository.findByTitle(title);
	}
	
	// THURSDAY: Read one movie
	
	// THURSDAY: Update a movie
	
	
	// THURSDAY: Delete a movie
}
