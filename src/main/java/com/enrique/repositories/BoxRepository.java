package com.enrique.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.BoxEntity;

public interface BoxRepository extends CrudRepository<BoxEntity, Long> {
	Optional<List<BoxEntity>> findByCategory(String category);

	Optional<BoxEntity> findByNameAndCategory(String name, String category);

	Optional<BoxEntity> findFirstByOrderByIdDesc();

}