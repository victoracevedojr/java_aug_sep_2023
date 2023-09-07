package com.adrianbarnard.week6demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.week6demo.models.Movie;
import com.adrianbarnard.week6demo.models.Performer;
import com.adrianbarnard.week6demo.repositories.MovieRepository;
import com.adrianbarnard.week6demo.repositories.PerformerRepository;

@Service
public class PerformerService {
	@Autowired
	private PerformerRepository performerRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	// Create a performer
	public Performer createPerformer(Performer newPerformer) {
		return performerRepository.save(newPerformer);
	}
	
	// Read all performers
	public List<Performer> readAllPerformers() {
		return performerRepository.findAll();
	}

	// Read one performer
	public Performer getOnePerformer(Long id) {
		Optional<Performer> performerOrEmpty = performerRepository.findById(id);
		return performerOrEmpty.isPresent() ? performerOrEmpty.get() : null;
	}
	
	// Update a performer
	public Performer updatePerformer(Performer updatedPerformer) {
		return performerRepository.save(updatedPerformer);
	}
	
	// Delete a performer (will fix in Wednesday's lecture)
	public void removePerformer(Long id) {
		Optional<Performer> thisPerformer = performerRepository.findById(id);
		if (thisPerformer.isPresent()) { // If performer is found
			Performer actualPerformer = thisPerformer.get(); // Grab actual Performer object
			// Remove this performer from all movies currently linked to them - but do NOT delete the Movies themselves
			for (Movie thisMovie: actualPerformer.getPerformerMovies()) {
				thisMovie.getPerformers().remove(actualPerformer); // Sever the connection between this Movie and the current Performer we're about to remove
				movieRepository.save(thisMovie); // Save the updated movie in the database
			}
			performerRepository.deleteById(id); // Now we'll remove the Performer
		}
	}
	
	// Link a new movie to this performer
	public Performer addMovieForPerformer(Long performerId, Long movieId) {
		Performer thisPerformer = this.getOnePerformer(performerId);
		Optional<Movie> possibleMovie = movieRepository.findById(movieId);
		if (possibleMovie.isEmpty()) {
			return null;
		}
		Movie thisMovie = possibleMovie.get();
		thisPerformer.getPerformerMovies().add(thisMovie); // Note the .add() method here as this is a List
		return performerRepository.save(thisPerformer); // Save changes to DB
	}
	
	// Link a new movie to this performer
	public Performer removeMovieFromPerformer(Long performerId, Long movieId) {
		Performer thisPerformer = this.getOnePerformer(performerId);
		Optional<Movie> possibleMovie = movieRepository.findById(movieId);
		if (possibleMovie.isEmpty()) {
			return null;
		}
		Movie thisMovie = possibleMovie.get();
		thisPerformer.getPerformerMovies().remove(thisMovie); // Note the .remove() method to delete from a List
		return performerRepository.save(thisPerformer); // Save changes to DB
	}
}
