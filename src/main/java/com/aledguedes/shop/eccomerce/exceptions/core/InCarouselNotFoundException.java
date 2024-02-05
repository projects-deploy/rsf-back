package com.aledguedes.shop.eccomerce.exceptions.core;

public class InCarouselNotFoundException extends ModelNotFoundException {
    
    private static final long serialVersionUID = 1L;

    public InCarouselNotFoundException() {
        super("Não encontramos o produto na lista de favoritos!");
    }

    public InCarouselNotFoundException(String message) {
        super(message);
    }
}
