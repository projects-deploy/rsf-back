package com.aledguedes.shop.eccomerce.exceptions.core;

public class CategoryNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException() {
        super("Categoria não econtrada");
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }

}