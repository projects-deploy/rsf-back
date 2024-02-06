package com.aledguedes.shop.eccomerce.exceptions.core;

public class NewsletterNotFoundException extends ModelNotFoundException {
    
    private static final long serialVersionUID = 1L;

    public NewsletterNotFoundException() {
        super("Não encontramos o produto na lista de favoritos!");
    }

    public NewsletterNotFoundException(String message) {
        super(message);
    }
}
