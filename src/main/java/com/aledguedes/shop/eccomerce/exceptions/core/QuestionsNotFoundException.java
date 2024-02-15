package com.aledguedes.shop.eccomerce.exceptions.core;

public class QuestionsNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public QuestionsNotFoundException() {
        super("Pergunta não foi econtrada");
    }

    public QuestionsNotFoundException(String message) {
        super(message);
    }

}