package com.enrique.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.managers.BoxManager;
import com.enrique.managers.CardManager;
import com.enrique.managers.CategoryManager;
import com.enrique.model.EditContainer;
import com.enrique.model.QuestionException;
import com.enrique.model.QuestionResponse;

@RestController
public class ConfigController {

	private CategoryManager categoryManager;
	private BoxManager boxManager;
	private CardManager cardManager;

	@Inject
	public ConfigController(CategoryManager categoryManager, BoxManager boxManager, CardManager cardManager) {
		this.categoryManager = categoryManager;
		this.boxManager = boxManager;
		this.cardManager = cardManager;
	}

	@ResponseBody
	@PostMapping(value = "/add_category")
	public QuestionResponse addCategory(@RequestParam("name") String name) {
		QuestionResponse response = new QuestionResponse();
		try {
			categoryManager.addCategory(name);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/edit_category")
	public QuestionResponse editCategory(@RequestParam("old_name") String oldName,
			@RequestParam("new_name") String newName) {
		EditContainer editContainer = new EditContainer(oldName, newName);
		QuestionResponse response = new QuestionResponse();
		try {
			categoryManager.editCategory(editContainer);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/delete_category")
	public QuestionResponse deleteCategory(@RequestParam("name") String name) {
		QuestionResponse response = new QuestionResponse();
		try {
			categoryManager.deleteCategory(name);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/add_box")
	public QuestionResponse addBox(@RequestParam("name") String name, @RequestParam("category") String category) {
		QuestionResponse response = new QuestionResponse();
		try {
			boxManager.addBox(name, category);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/edit_box")
	public QuestionResponse editBox(@RequestParam("old_name") String oldOne, @RequestParam("new_name") String newOne,
			@RequestParam("category") String category) {
		EditContainer editContainer = new EditContainer(oldOne, newOne);
		QuestionResponse response = new QuestionResponse();
		try {
			boxManager.editBox(editContainer, category);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/delete_box")
	public QuestionResponse deleteBox(@RequestParam("name") String name, @RequestParam("category") String category) {
		QuestionResponse response = new QuestionResponse();
		try {
			boxManager.deleteBox(name, category);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/add_card")
	public QuestionResponse addCard(@RequestParam("name") String name, @RequestParam("category") String category,
			@RequestParam("box") String box) {
		QuestionResponse response = new QuestionResponse();
		try {
			cardManager.addCard(name, category, box);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/edit_card")
	public QuestionResponse editCard(@RequestParam("old_name") String oldOne, @RequestParam("new_name") String newOne,
			@RequestParam("category") String category, @RequestParam("box") String box) {
		EditContainer editContainer = new EditContainer(oldOne, newOne);
		QuestionResponse response = new QuestionResponse();
		try {
			cardManager.editCard(editContainer, category, box);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@ResponseBody
	@PostMapping(value = "/delete_card")
	public QuestionResponse deleteCard(@RequestParam("name") String name, @RequestParam("category") String category,
			@RequestParam("box") String box) {
		QuestionResponse response = new QuestionResponse();
		try {
			cardManager.deleteCard(name, category, box);
		} catch (QuestionException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

}
