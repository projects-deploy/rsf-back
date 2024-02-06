package com.aledguedes.shop.eccomerce.exceptions.core;

public class ColecoesNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public ColecoesNotFoundException() {
        super("Sub Categoria não econtrada");
    }

    public ColecoesNotFoundException(String message) {
        super(message);
    }

}