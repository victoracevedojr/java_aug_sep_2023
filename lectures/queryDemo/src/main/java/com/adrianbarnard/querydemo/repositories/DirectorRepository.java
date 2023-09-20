package com.adrianbarnard.querydemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.querydemo.models.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
	List<Director> findAll();
	
	@Query("SELECT d.firstName, d.lastName FROM Director d") // Grab first and last name ONLY
	List<Object[]> findAllWithFirstAndLastName(); // To allow flexibility of data types so we can use String, Integer, etc.
	
	@Query(value="SELECT * FROM directors"
			+ " LEFT JOIN (SELECT director_id, COUNT(director_id) FROM movies GROUP BY director_id) movie_counts "
			+ " ON movie_counts.director_id = directors.id;", nativeQuery = true)
	List<Object[]> findWithFirstAndLastNamesAndCount();
}
