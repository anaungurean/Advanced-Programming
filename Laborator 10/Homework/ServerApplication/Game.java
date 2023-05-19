package org.example;

import org.example.Board;
import org.example.Player;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;

    public Game() {
        board = new Board(15,15);
        players = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        if (players.size() < 2) {
            players.add(player);
            return true;
        }
        return false;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean start() {
        if (players.size() == 2) {
            board.reset();
            currentPlayer = players.get(0);
            return true;
        }
        return false;
    }
    public void end() {
        currentPlayer = null;
        players.clear();
    }

    public Player makeMove(int row, int col) {
        if (board.isValidMove(row, col)) {
            board.placePiece(row, col, currentPlayer.getPiece());
            if (checkWinner(row, col)) {
                return currentPlayer;
            } else {
                currentPlayer = getNextPlayer();
            }
        }
        return null;
    }

    private boolean checkWinner(int row, int col) {
        char piece = board.getPiece(row, col);
        return checkHorizontal(row, col, piece) ||
                checkVertical(row, col, piece) ||
                checkDiagonal(row, col, piece);
    }

    private boolean checkHorizontal(int row, int col, char piece) {
        int count = 1;
        int leftCol = col - 1;
        while (leftCol >= 0 && board.getPiece(row, leftCol) == piece) {
            count++;
            leftCol--;
        }
        int rightCol = col + 1;
        while (rightCol < board.getWidth() && board.getPiece(row, rightCol) == piece) {
            count++;
            rightCol++;
        }
        return count >= 2;
    }

    private boolean checkVertical(int row, int col, char piece) {
        int count = 1;
        int topRow = row - 1;
        while (topRow >= 0 && board.getPiece(topRow, col) == piece) {
            count++;
            topRow--;
        }
        int bottomRow = row + 1;
        while (bottomRow < board.getHeight() && board.getPiece(bottomRow, col) == piece) {
            count++;
            bottomRow++;
        }
        return count >= 2;
    }

    private boolean checkDiagonal(int row, int col, char piece) {
        int count = 1;
        int topLeftRow = row - 1;
        int topLeftCol = col - 1;
        while (topLeftRow >= 0 && topLeftCol >= 0 && board.getPiece(topLeftRow, topLeftCol) == piece) {
            count++;
            topLeftRow--;
            topLeftCol--;
        }
        int bottomRightRow = row + 1;
        int bottomRightCol = col + 1;
        while (bottomRightRow < board.getHeight() && bottomRightCol < board.getWidth() && board.getPiece(bottomRightRow, bottomRightCol) == piece) {
            count++;
            bottomRightRow++;
            bottomRightCol++;
        }
        if (count >= 5) {
            return true;
        }
        count = 1;
        int topRightRow = row - 1;
        int topRightCol = col + 1;
        while (topRightRow >= 0 && topRightCol < board.getWidth() && board.getPiece(topRightRow, topRightCol) == piece) {
            count++;
            topRightRow--;
            topRightCol++;
        }
        int bottomLeftRow = row + 1;
        int bottomLeftCol = col - 1;
        while (bottomLeftRow < board.getHeight() && bottomLeftCol >= 0 && board.getPiece(bottomLeftRow, bottomLeftCol) == piece) {
            count++;
            bottomLeftRow++;
            bottomLeftCol--;
        }
        return count >= 2;
    }

    private Player getNextPlayer() {
        return currentPlayer == players.get(0) ? players.get(1) : players.get(0);
    }
}
