package com.enrique.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
	Optional<CategoryEntity> findByName(String name);

	Optional<CategoryEntity> findFirstByOrderByIdDesc();

}