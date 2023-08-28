package com.adrianbarnard.starterweek5demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.starterweek5demo.models.Director;
import com.adrianbarnard.starterweek5demo.repositories.DirectorRepository;

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
		directorRepository.deleteById(id);
	}
}
