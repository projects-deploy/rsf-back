package com.aledguedes.shop.eccomerce.exceptions.core;

public class ModelNotFoundException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ModelNotFoundException(String message) {
		super(message);
	}
}
