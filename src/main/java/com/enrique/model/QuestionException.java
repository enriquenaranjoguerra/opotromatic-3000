package com.enrique.model;

public class QuestionException extends RuntimeException {
	private static final long serialVersionUID = 4192290926854076734L;

	// TODO dale utilidad a esto
	public QuestionException() {
	}

	public QuestionException(String message) {
		super(message);
	}
}
