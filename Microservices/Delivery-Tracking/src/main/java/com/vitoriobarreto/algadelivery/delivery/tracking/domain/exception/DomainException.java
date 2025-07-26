package com.vitoriobarreto.algadelivery.delivery.tracking.domain.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }

    public DomainException() {
    }
}
