package com.adrianbarnard.querydemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.querydemo.models.Director;
import com.adrianbarnard.querydemo.models.Movie;
import com.adrianbarnard.querydemo.repositories.DirectorRepository;

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
	
	// Grab all directors by first and last name ONLY
	public ArrayList<String> getFirstAndLastName() {
		List<Object[]> allDirectorsNames = directorRepository.findAllWithFirstAndLastName();
		ArrayList<String> fullDirectorNames = new ArrayList<String>();
		for (Object[] currentSetOfNames : allDirectorsNames) {
			String firstName = (String) currentSetOfNames[0]; // Must type-cast accordingly!!
			String lastName = (String) currentSetOfNames[1];
//			System.out.println(currentSetOfNames[0]);
//			System.out.println(currentSetOfNames[1]);
			fullDirectorNames.add(firstName + " " + lastName);
		}
		return fullDirectorNames;
	}
	
	// Grab all the directors by name AND the number of movies directed
	public void getAllWithMovieCounts() {
		List<Object[]> allDirectors = directorRepository.findWithFirstAndLastNamesAndCount();
		for (Object[] currentDirector : allDirectors) {
			System.out.println(currentDirector[0]);
			System.out.println(currentDirector[1]);
			System.out.println(currentDirector[2]);
			System.out.println(currentDirector[3]); // First name
			System.out.println(currentDirector[4]); // Last name
			System.out.println(currentDirector[5]);
			System.out.println(currentDirector[6]);
			System.out.println(currentDirector[7]); // Movie count (null if there aren't any)
		}
	}
}
