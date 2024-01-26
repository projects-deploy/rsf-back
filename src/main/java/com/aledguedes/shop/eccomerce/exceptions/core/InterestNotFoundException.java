package com.aledguedes.shop.eccomerce.exceptions.core;

public class InterestNotFoundException extends ModelNotFoundException {
    
	private static final long serialVersionUID = 1L;

	public InterestNotFoundException() {
        super("Não encontramos o produto na lista de favoritos!");
    }

    public InterestNotFoundException(String message) {
        super(message);
    }
}
