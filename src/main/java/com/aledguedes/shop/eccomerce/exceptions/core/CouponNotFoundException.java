package com.aledguedes.shop.eccomerce.exceptions.core;

public class CouponNotFoundException  extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public CouponNotFoundException() {
        super("O coupon não foi encontrado e/ou inválido/expirado!");
    }

    public CouponNotFoundException(String message) {
        super(message);
    }
}
