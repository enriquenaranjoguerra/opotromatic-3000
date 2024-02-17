package com.enrique.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.CardEntity;

public interface CardRepository extends CrudRepository<CardEntity, Long> {
	Optional<CardEntity> findByName(String name);

	Optional<List<CardEntity>> findByCategory(String category);

	Optional<CardEntity> findByNameAndCategoryAndBox(String name, String category, String box);

	Optional<List<CardEntity>> findByCategoryAndBox(String category, String box);

	Optional<CardEntity> findFirstByOrderByIdDesc();
}