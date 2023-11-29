package com.aledguedes.shop.eccomerce.exceptions.core;

public class FavoriteProductsNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public FavoriteProductsNotFoundException() {
        super("Não encontramos o produto na lista de favoritos!");
    }

    public FavoriteProductsNotFoundException(String message) {
        super(message);
    }
    
    
}
