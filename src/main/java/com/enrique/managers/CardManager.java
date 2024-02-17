package com.enrique.managers;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.enrique.entities.CardEntity;
import com.enrique.model.EditContainer;
import com.enrique.model.QuestionException;
import com.enrique.repositories.CardRepository;

@Service
public class CardManager {
	private CardRepository cardRepository;
	private QuestionException listEmptyException = new QuestionException("The list of cards is empty");

	public CardManager(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	public void addCard(String name, String category, String box) {
		CardEntity lastCard = cardRepository.findFirstByOrderByIdDesc().orElseThrow(() -> listEmptyException);
		cardRepository.save(new CardEntity(lastCard.getId() + 1L, name, category, box));
	}

	public void deleteCard(String name, String category, String box) {
		cardRepository.delete(
				cardRepository.findByNameAndCategoryAndBox(name, category, box).orElseThrow(() -> listEmptyException));
	}

	public boolean editCard(EditContainer editContainer, String category, String box) {
		CardEntity exitingCard = cardRepository.findByNameAndCategoryAndBox(editContainer.getOldOne(), category, box)
				.orElseThrow(() -> new QuestionException("No element found with name " + editContainer.getOldOne()));
		if (!StringUtils.isEmpty(editContainer.getNewOne())) {
			cardRepository.save(new CardEntity(exitingCard.getId(), editContainer.getNewOne(), category, box));
			return true;
		} else {
			throw new QuestionException(
					"Card " + editContainer.getNewOne() + " does not exits or a null value was provided");
		}
	}

}
