package com.flipkart.machinecode.flipkartapp.exceptions;

public class IncorrectBillException extends RuntimeException {

    public IncorrectBillException(String msq) {
        super(msq);
    }
}
