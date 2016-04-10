package com.company.kovalenko;

import java.io.IOException;

public class RequestedFlowerNotInListException extends IOException {

    public RequestedFlowerNotInListException() {
    }

    public RequestedFlowerNotInListException(String message) {
        super(message);
    }
}
