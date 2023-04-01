package org.example.Exceptions;

public class PageNotFoundException extends Exception {
    private String msg;

    public PageNotFoundException(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "PageNotFoundException " + this.msg;
    }
}
