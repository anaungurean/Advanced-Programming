package org.example.Exceptions;
public class DuplicateIdException extends Exception {
    public DuplicateIdException(String msg) {
        super(msg);
    }

    public String toString() {
        return "DuplicateIdException";
    }
}