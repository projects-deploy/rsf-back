package com.aledguedes.shop.eccomerce.exceptions.coupons;

public class InvalidCouponProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCouponProductException() {
        super("O cupom não é válido para o produto fornecido.");
    }

    public InvalidCouponProductException(String message) {
        super(message);
    }
}