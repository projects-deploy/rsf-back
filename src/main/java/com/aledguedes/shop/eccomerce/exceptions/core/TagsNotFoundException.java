package com.aledguedes.shop.eccomerce.exceptions.core;

public class TagsNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public TagsNotFoundException() {
        super("Marca não econtrada");
    }

    public TagsNotFoundException(String message) {
        super(message);
    }

}
