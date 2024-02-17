package com.enrique.model;

import java.util.List;

import com.enrique.entities.BoxEntity;
import com.enrique.entities.CardEntity;
import com.enrique.entities.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class QuestionPackage {

	@Getter
	private CategoryEntity categoryEntity;
	@Getter
	private List<BoxEntity> listOfBoxes;
	@Getter
	private List<CardEntity> listOfCards;
	@Getter
	private String errorMessage;
}
