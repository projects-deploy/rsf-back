package com.aledguedes.shop.eccomerce.exceptions.core;

public class DepartmentNotFoundException extends ModelNotFoundException {

    private static final long serialVersionUID = 1L;

    public DepartmentNotFoundException() {
        super("Categoria não econtrada");
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

}