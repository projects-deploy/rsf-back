package com.aledguedes.shop.eccomerce.exceptions.coupons;

import com.aledguedes.shop.eccomerce.exceptions.core.ModelNotFoundException;

public class InactiveCouponException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

	public InactiveCouponException() {
        super("O cupom não está ativo.");
    }

    public InactiveCouponException(String message) {
        super(message);
    }
}