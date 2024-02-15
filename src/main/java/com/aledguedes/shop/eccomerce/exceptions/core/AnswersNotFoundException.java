package com.aledguedes.shop.eccomerce.exceptions.core;

public class AnswersNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public AnswersNotFoundException() {
        super("Resposta não foi econtrada");
    }

    public AnswersNotFoundException(String message) {
        super(message);
    }

}