package com.aledguedes.shop.eccomerce.exceptions.core;

public class NotifyArrivalNotFoundException extends ModelNotFoundException {
    
    private static final long serialVersionUID = 1L;

    public NotifyArrivalNotFoundException() {
        super("Não encontramos o produto na lista de favoritos!");
    }

    public NotifyArrivalNotFoundException(String message) {
        super(message);
    }
}
