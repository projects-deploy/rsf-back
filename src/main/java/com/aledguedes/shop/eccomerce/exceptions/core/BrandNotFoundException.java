package com.aledguedes.shop.eccomerce.exceptions.core;

public class BrandNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public BrandNotFoundException() {
        super("Marca não econtrada");
    }

    public BrandNotFoundException(String message) {
        super(message);
    }

}