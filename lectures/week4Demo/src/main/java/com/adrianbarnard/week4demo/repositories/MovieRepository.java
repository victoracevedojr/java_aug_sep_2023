package com.adrianbarnard.week4demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.week4demo.models.Movie;

@Repository // IMPORTANT to include the proper annotations!
public interface MovieRepository extends CrudRepository<Movie, Long> {
	List<Movie> findAll(); // Grab all the Movies from the database (equivalent to "SELECT * FROM movies")
	
	List<Movie> findByTitle(String title); // Equivalent to "SELECT * FROM movies WHERE title = ???";
}
