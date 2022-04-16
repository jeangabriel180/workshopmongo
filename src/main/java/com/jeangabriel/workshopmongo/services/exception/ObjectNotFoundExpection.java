package com.jeangabriel.workshopmongo.services.exception;

public class ObjectNotFoundExpection extends RuntimeException {
    public ObjectNotFoundExpection(String msg) {
        super(msg);
    }
}
