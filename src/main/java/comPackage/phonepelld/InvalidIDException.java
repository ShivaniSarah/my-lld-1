package org.example;

class InvalidIDException extends RuntimeException {
    InvalidIDException(String message) {
        super(message);
    }
}
