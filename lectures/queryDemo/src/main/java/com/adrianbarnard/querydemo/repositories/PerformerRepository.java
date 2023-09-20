package com.adrianbarnard.querydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.querydemo.models.Performer;

@Repository
public interface PerformerRepository extends CrudRepository<Performer, Long> {
	List<Performer> findAll();
}
