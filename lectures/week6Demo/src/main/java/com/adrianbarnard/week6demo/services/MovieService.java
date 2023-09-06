package com.adrianbarnard.week6demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrianbarnard.week6demo.models.Movie;
import com.adrianbarnard.week6demo.models.Performer;
import com.adrianbarnard.week6demo.repositories.MovieRepository;

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
	
	// Read one movie
	public Movie getOneMovie(Long id) {
		Optional<Movie> movieOrEmpty = movieRepository.findById(id);
		return movieOrEmpty.isPresent() ? movieOrEmpty.get() : null; // One-line version of the code below using a ternary operator
//		if (movieOrEmpty.isPresent()) {
//			return movieOrEmpty.get(); // Return Movie object
//		} else {
//			return null; // No object found, so return null
//		}
	}
	
	// Update a movie
	public Movie updateMovie(Movie updatedMovie) {
		return movieRepository.save(updatedMovie);
	}
	
	// Delete a movie
	public void removeMovie(Long id) {
		movieRepository.deleteById(id);
//		movieRepository.delete(movieToRemove); // movieToRemove would be a Movie object
	}
	
	// Grab all movies NOT linked to a performer
	public List<Movie> findMoviesWithoutPerformer(Performer thisPerformer) {
		return movieRepository.findAllByPerformersNotContaining(thisPerformer);
	}
}
