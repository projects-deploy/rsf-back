package com.aledguedes.shop.eccomerce.exceptions.coupons;

public class InactiveCouponException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InactiveCouponException() {
        super("O cupom não está ativo.");
    }

    public InactiveCouponException(String message) {
        super(message);
    }
}