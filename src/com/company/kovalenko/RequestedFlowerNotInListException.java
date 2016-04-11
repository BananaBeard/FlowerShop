package com.company.kovalenko;

import java.io.IOException;

public class RequestedFlowerNotInListException extends IOException {

    private String name;
    public RequestedFlowerNotInListException() {
    }

    public RequestedFlowerNotInListException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
