package org.example;

public class Board {
    private int width;
    private int height;
    private char[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new char[height][width];
        reset();
    }



    public void reset() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = '-';
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width && grid[row][col] == '-';
    }

    public void placePiece(int row, int col, char piece) {
        grid[row][col] = piece;
    }

    public char getPiece(int row, int col) {
        return grid[row][col];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

