package com.aledguedes.shop.eccomerce.exceptions.core;

public class CustomerNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException() {
        super("Cliente não econtrado");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }

}