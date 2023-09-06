package com.adrianbarnard.week6demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.week6demo.models.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
	List<Director> findAll();
}
