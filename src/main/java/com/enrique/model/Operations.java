package com.enrique.model;

public enum Operations {

	EDIT("edit"), ADD("add"), DELETE("delete");

	private String name;

	private Operations(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
