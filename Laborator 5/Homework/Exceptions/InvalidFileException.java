package org.example.Exceptions;


public class InvalidFileException extends Exception {
    private String msg;

    public InvalidFileException(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "InvalidDocumentException " + this.msg;
    }
}