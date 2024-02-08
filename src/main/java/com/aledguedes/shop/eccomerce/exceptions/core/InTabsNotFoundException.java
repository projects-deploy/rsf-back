package com.aledguedes.shop.eccomerce.exceptions.core;

public class InTabsNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public InTabsNotFoundException() {
        super("Marca não econtrada");
    }

    public InTabsNotFoundException(String message) {
        super(message);
    }

}