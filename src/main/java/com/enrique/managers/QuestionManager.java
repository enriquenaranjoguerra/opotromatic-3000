package com.enrique.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.enrique.entities.BoxEntity;
import com.enrique.entities.CardEntity;
import com.enrique.entities.CategoryEntity;
import com.enrique.model.QuestionException;
import com.enrique.model.QuestionPackage;
import com.enrique.model.QuestionResponse;
import com.enrique.repositories.BoxRepository;
import com.enrique.repositories.CardRepository;
import com.enrique.repositories.CategoryRepository;

@Service
public class QuestionManager {

	private BoxRepository boxRepository;
	private CardRepository cardRepository;
	private CategoryRepository categoryRepository;

	private static final QuestionException CATEGORY_LIST_EMPTY_EXCEPTION = new QuestionException(
			"The list of categories is empty");
	private static final QuestionException BOX_LIST_EMPTY_EXCEPTION = new QuestionException(
			"The list of boxes is empty");
	private static final QuestionException CARD_LIST_EMPTY_EXCEPTION = new QuestionException(
			"The list of cards is empty");

	@Inject
	public QuestionManager(CategoryRepository categoryRepository, BoxRepository boxRepository,
			CardRepository cardRepository) {
		this.categoryRepository = categoryRepository;
		this.boxRepository = boxRepository;
		this.cardRepository = cardRepository;
	}

	public List<CategoryEntity> getAllCategories() {
		List<CategoryEntity> allCategories = new ArrayList<>();
		categoryRepository.findAll().forEach(allCategories::add);
		return allCategories;
	}

	public QuestionPackage getQuestionsByCategory(String categoryName) {
		try {
			CategoryEntity category = categoryRepository.findByName(categoryName)
					.orElseThrow(() -> CATEGORY_LIST_EMPTY_EXCEPTION);
			List<BoxEntity> box = boxRepository.findByCategory(categoryName)
					.orElseThrow(() -> BOX_LIST_EMPTY_EXCEPTION);
			List<CardEntity> card = cardRepository.findByCategory(categoryName)
					.orElseThrow(() -> CARD_LIST_EMPTY_EXCEPTION);
			return new QuestionPackage(category, box, card, "");
		} catch (QuestionException e) {
			return new QuestionPackage(null, null, null, e.getMessage());
		}
	}

	public QuestionResponse checkCardBelongsToBox(String boxName, String cardName) {
		CardEntity card = cardRepository.findByName(cardName).orElseThrow(() -> CARD_LIST_EMPTY_EXCEPTION);
		if (!boxName.equals(card.getBox())) {
			return new QuestionResponse("La carta \"" + cardName + "\" no pertenece a la caja \"" + boxName + "\"");
		}
		return new QuestionResponse();
	}

	public List<BoxEntity> getAllBoxesForCategory(String category) {
		return boxRepository.findByCategory(category).orElseGet(ArrayList::new);
	}

	public List<CardEntity> getAllCardsForCategoryAndBox(String category, String box) {
		return cardRepository.findByCategoryAndBox(category, box).orElseGet(ArrayList::new);
	}

	public String getBoxByCard(String card) {
		Optional<CardEntity> cardEntity = cardRepository.findByName(card);
		return cardEntity.isPresent() ? cardEntity.get().getBox() : "";
	}
}
