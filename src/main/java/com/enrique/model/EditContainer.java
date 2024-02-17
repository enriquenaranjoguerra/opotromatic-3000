package com.enrique.model;

import javax.validation.constraints.NotNull;

public class EditContainer {
	private String oldOne;
	private String newOne;

	public EditContainer() {
	}

	public EditContainer(@NotNull String oldOne, String newOne) {
		this.oldOne = oldOne;
		this.newOne = newOne;
	}

	public String getOldOne() {
		return oldOne;
	}

	public void setOldOne(@NotNull String oldOne) {
		this.oldOne = oldOne;
	}

	public String getNewOne() {
		return newOne;
	}

	public void setNewOne(String newOne) {
		this.newOne = newOne;
	}

	@Override
	public String toString() {
		return "EditContainer [oldOne=" + oldOne + ", newOne=" + newOne + "]";
	}

}
