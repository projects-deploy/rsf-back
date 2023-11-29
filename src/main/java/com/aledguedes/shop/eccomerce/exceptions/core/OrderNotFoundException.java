package com.aledguedes.shop.eccomerce.exceptions.core;

public class OrderNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public OrderNotFoundException() {
        super("Pedido não econtrado");
    }

	public OrderNotFoundException(String message) {
		super(message);
	}

}
