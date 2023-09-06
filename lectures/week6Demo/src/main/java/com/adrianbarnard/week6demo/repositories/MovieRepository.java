package com.adrianbarnard.week6demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.week6demo.models.Movie;
import com.adrianbarnard.week6demo.models.Performer;

@Repository // IMPORTANT to include the proper annotations!
public interface MovieRepository extends CrudRepository<Movie, Long> {
	List<Movie> findAll(); // Grab all the Movies from the database (equivalent to "SELECT * FROM movies")
	
	List<Movie> findByTitle(String title); // Equivalent to "SELECT * FROM movies WHERE title = ???";
	
	// Method to grab all movies NOT linked to a performer
	List<Movie> findAllByPerformersNotContaining(Performer performer); // Equivalent to "SELECT * FROM movies WHERE id NOT IN (SELECT movie_id FROM performers_movies WHERE performer_id = ???);"
}
