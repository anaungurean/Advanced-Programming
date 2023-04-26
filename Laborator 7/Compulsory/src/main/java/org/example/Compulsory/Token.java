package org.example.Compulsory;

public class Token {
    private final int number ;

    public Token(int number) {
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    @Override
    public String toString() {
        return "TOKEN(" + this.number + ");";
    }
}
