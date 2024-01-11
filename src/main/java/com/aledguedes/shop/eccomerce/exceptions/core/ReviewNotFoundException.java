package com.aledguedes.shop.eccomerce.exceptions.core;

public class ReviewNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public ReviewNotFoundException() {
        super("Comentários não foram econtrados");
    }

    public ReviewNotFoundException(String message) {
        super(message);
    }

}