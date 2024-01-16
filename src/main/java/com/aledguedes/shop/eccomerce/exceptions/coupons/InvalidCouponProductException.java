package com.aledguedes.shop.eccomerce.exceptions.coupons;

import com.aledguedes.shop.eccomerce.exceptions.core.ModelNotFoundException;

public class InvalidCouponProductException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

	public InvalidCouponProductException() {
        super("O cupom não é válido para o produto fornecido.");
    }

    public InvalidCouponProductException(String message) {
        super(message);
    }
}