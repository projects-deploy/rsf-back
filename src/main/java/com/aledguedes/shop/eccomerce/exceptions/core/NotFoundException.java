package com.aledguedes.shop.eccomerce.exceptions.core;

public class NotFoundException extends ModelNotFoundException {
    
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Não encontramos o produto na lista de favoritos!");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
