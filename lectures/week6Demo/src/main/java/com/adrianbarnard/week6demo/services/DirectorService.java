package com.adrianbarnard.week6demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.week6demo.models.Director;
import com.adrianbarnard.week6demo.models.Movie;
import com.adrianbarnard.week6demo.repositories.DirectorRepository;

@Service
public class DirectorService {
	@Autowired
	private DirectorRepository directorRepository;
	
	// Create a director
	public Director createDirector(Director newDirector) {
		return directorRepository.save(newDirector);
	}
	
	// Read all directors
	public List<Director> readAllDirectors() {
		return directorRepository.findAll();
	}

	// Read one director
	public Director getOneDirector(Long id) {
		Optional<Director> directorOrEmpty = directorRepository.findById(id);
		return directorOrEmpty.isPresent() ? directorOrEmpty.get() : null;
	}
	
	// Update a director
	public Director updateDirector(Director updatedDirector) {
		return directorRepository.save(updatedDirector);
	}
	
	// Delete a director
	public void removeDirector(Long id) {
		Optional<Director> thisDirector = directorRepository.findById(id);
		if (thisDirector.isPresent()) { // If director is found
			Director actualDirector = thisDirector.get(); // Grab actual Director object
			// Remove this director from all movies currently linked to them - but do NOT delete the Movies themselves
			for (Movie thisMovie: actualDirector.getMovies()) {
				thisMovie.setMovieDirector(null); // Sever the connection between this Movie and the current Director we're about to remove
			}
			directorRepository.deleteById(id); // Now we'll remove the Director
		}
	}
}
