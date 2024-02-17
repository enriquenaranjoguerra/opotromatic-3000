package com.enrique.managers;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.enrique.entities.BoxEntity;
import com.enrique.model.EditContainer;
import com.enrique.model.QuestionException;
import com.enrique.repositories.BoxRepository;

@Service
public class BoxManager {
	private BoxRepository boxRepository;
	private QuestionException listEmptyException = new QuestionException("The list of boxes is empty");

	public BoxManager(BoxRepository boxRepository) {
		this.boxRepository = boxRepository;
	}

	public void addBox(String name, String category) {
		BoxEntity lastBox = boxRepository.findFirstByOrderByIdDesc().orElseThrow(() -> listEmptyException);
		boxRepository.save(new BoxEntity(lastBox.getId() + 1L, name, category));
	}

	public void deleteBox(String name, String category) {
		boxRepository.delete(boxRepository.findByNameAndCategory(name, category).orElseThrow(() -> listEmptyException));
	}

	public boolean editBox(EditContainer editContainer, String category) {
		BoxEntity exitingBox = boxRepository.findByNameAndCategory(editContainer.getOldOne(), category)
				.orElseThrow(() -> new QuestionException("No element found with name " + editContainer.getOldOne()));
		if (!StringUtils.isEmpty(editContainer.getNewOne())) {
			boxRepository.save(new BoxEntity(exitingBox.getId(), editContainer.getNewOne(), category));
			return true;
		} else {
			throw new QuestionException(
					"Box " + editContainer.getNewOne() + " does not exits or a null value was provided");
		}
	}

}
