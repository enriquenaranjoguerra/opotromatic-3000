package com.enrique.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.entities.BoxEntity;
import com.enrique.entities.CardEntity;
import com.enrique.entities.CategoryEntity;
import com.enrique.managers.QuestionManager;
import com.enrique.model.QuestionPackage;
import com.enrique.model.QuestionResponse;

@RestController
public class QuestionController {

	private QuestionManager questionManager;

	@Inject
	public QuestionController(QuestionManager questionManager) {
		this.questionManager = questionManager;
	}

	@ResponseBody
	@GetMapping(value = "/get_all_categories")
	public List<CategoryEntity> getAllCategories() {
		return questionManager.getAllCategories();
	}

	@ResponseBody
	@GetMapping(value = "/get_all_boxes_for_category")
	public List<BoxEntity> getAllBoxesForCategory(@RequestParam("category") String category) {
		return questionManager.getAllBoxesForCategory(category);
	}

	@ResponseBody
	@GetMapping(value = "/get_all_cards_for_category_and_box")
	public List<CardEntity> getAllCardsForCategoryAndBox(@RequestParam("category") String category,
			@RequestParam("box") String box) {
		return questionManager.getAllCardsForCategoryAndBox(category, box);
	}

	@ResponseBody
	@GetMapping(value = "/get_questions_by_category")
	public QuestionPackage getQuestionsByCategory(@RequestParam("category") String category) {
		return questionManager.getQuestionsByCategory(category);
	}

	@ResponseBody
	@GetMapping(value = "/check_card_belongs_to_box")
	public QuestionResponse checkCardBelongsToBox(@RequestParam("card") String card, @RequestParam("box") String box) {
		return questionManager.checkCardBelongsToBox(box, card);
	}

	@ResponseBody
	@GetMapping("/get_box_by_card")
	public String getBoxByCard(@RequestParam("card") String card) {
		String box = questionManager.getBoxByCard(card);
		System.out.println(card + " corresponds to box " + box);
		return box;
	}
}
