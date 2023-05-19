package org.example;

public class Player {
    private String name;
    private char piece;
    private Game game;

    public Player(String name, char piece) {
        this.name = name;
        this.piece = piece;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public char getPiece() {
        return piece;
    }
}
