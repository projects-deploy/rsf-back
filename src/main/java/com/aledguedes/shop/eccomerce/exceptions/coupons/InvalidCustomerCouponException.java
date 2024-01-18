package com.aledguedes.shop.eccomerce.exceptions.coupons;

import com.aledguedes.shop.eccomerce.exceptions.core.ModelNotFoundException;

public class InvalidCustomerCouponException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public InvalidCustomerCouponException() {
        super("Cupom não pertence a este cliente");
    }

    public InvalidCustomerCouponException(String message) {
        super(message);
    }
}
