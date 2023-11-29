package com.aledguedes.shop.eccomerce.exceptions.core;

public class ProductNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException() {
        super("Produto não econtrado");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

}