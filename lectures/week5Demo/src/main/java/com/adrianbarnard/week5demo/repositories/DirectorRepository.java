package com.adrianbarnard.week5demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.week5demo.models.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
	List<Director> findAll();
}
