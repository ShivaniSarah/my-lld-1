package org.example;

class IdNotFoundException extends RuntimeException {
    IdNotFoundException(String message) {
        super(message);
    }
}
