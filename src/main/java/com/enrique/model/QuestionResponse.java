package com.enrique.model;

import org.springframework.util.StringUtils;

public class QuestionResponse {

	private boolean isCorrect;
	private String message;

	public QuestionResponse() {
		this.isCorrect = true;
	}

	public QuestionResponse(String message) {
		this.isCorrect = false;
		this.message = message;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		if (!StringUtils.isEmpty(message)) {
			this.isCorrect = false;
			this.message = message;
		}
	}

}
