package com.aledguedes.shop.eccomerce.exceptions.core;

public class InCarouselNotFoundException extends ModelNotFoundException {
    
    private static final long serialVersionUID = 1L;

    public InCarouselNotFoundException() {
        super("Carouosel ID não encontrado!");
    }

    public InCarouselNotFoundException(String message) {
        super(message);
    }
}
