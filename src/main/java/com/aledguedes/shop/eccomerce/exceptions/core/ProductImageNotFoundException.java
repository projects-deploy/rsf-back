package com.aledguedes.shop.eccomerce.exceptions.core;

public class ProductImageNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public ProductImageNotFoundException() {
        super("Lista de imagens do produto não foi econtrada");
    }

    public ProductImageNotFoundException(String message) {
        super(message);
    }

}