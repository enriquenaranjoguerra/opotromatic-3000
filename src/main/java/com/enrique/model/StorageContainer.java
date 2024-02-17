package com.enrique.model;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public class StorageContainer<T, V> {

	private T mainElem;
	private List<V> assocElem;

	public StorageContainer(T main, List<V> assoc) {
		this.mainElem = main;
		this.assocElem = assoc;
	}

	public StorageContainer(T main) {
		this.mainElem = main;
		this.assocElem = new ArrayList<>();
	}

	public T getMainElem() {
		return mainElem;
	}

	public List<V> getAssocElem() {
		return assocElem;
	}

	public void setMainElem(T main) {
		this.mainElem = main;
	}

	public void setAssocElem(List<V> assoc) {
		this.assocElem = assoc;
	}

	public void addAssocElem(V newElem) {
		this.assocElem.add(newElem);
	}

	public void addAssocElem(List<V> newElems) {
		this.assocElem.addAll(newElems);
	}

}