package com.aledguedes.shop.eccomerce.exceptions.core;

public class HighlightsNotFoundException extends ModelNotFoundException {
    
    private static final long serialVersionUID = 1L;

    public HighlightsNotFoundException() {
        super("Não encontramos o produto na lista de favoritos!");
    }

    public HighlightsNotFoundException(String message) {
        super(message);
    }
}
