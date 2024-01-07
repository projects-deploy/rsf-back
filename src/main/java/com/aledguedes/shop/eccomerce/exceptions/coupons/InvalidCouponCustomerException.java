package com.aledguedes.shop.eccomerce.exceptions.coupons;

public class InvalidCouponCustomerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCouponCustomerException() {
        super("O cupom não é válido para o cliente fornecido.");
    }

    public InvalidCouponCustomerException(String message) {
        super(message);
    }
}