package com.aledguedes.shop.eccomerce.exceptions.core;

public class SubCategoryNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public SubCategoryNotFoundException() {
        super("Sub Categoria não econtrada");
    }

    public SubCategoryNotFoundException(String message) {
        super(message);
    }

}