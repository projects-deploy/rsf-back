package com.aledguedes.shop.eccomerce.exceptions.coupons;

public class InvalidCustomerCouponException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCustomerCouponException() {
        super("Cupom não pertence a este cliente");
    }

    public InvalidCustomerCouponException(String message) {
        super(message);
    }
}
