package com.aledguedes.shop.eccomerce.exceptions.coupons;

import com.aledguedes.shop.eccomerce.exceptions.core.ModelNotFoundException;

public class InvalidCouponCustomerException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

	public InvalidCouponCustomerException() {
        super("O cupom não é válido para o cliente fornecido.");
    }

    public InvalidCouponCustomerException(String message) {
        super(message);
    }
}