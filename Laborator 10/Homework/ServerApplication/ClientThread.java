package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

class ClientThread extends Thread {
    private static final long BLITZ_TIME_LIMIT = 60000;
    private Socket socket = null;
    private Game game;
    private Timer timer;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request;
            String response;

            while ((request = in.readLine()) != null) {
                response = handleCommand(request);
                out.println(response);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                game.end();
                try {
                    sendTimeoutMessage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, BLITZ_TIME_LIMIT);
    }

    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void sendTimeoutMessage() throws IOException {
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Time is up. The game has ended.");
        out.flush();
    }

    private String handleCommand(String command) {
        if (command.equalsIgnoreCase("create game")) {
            this.game = GameManager.createGame();
            Player player1 = new Player("Player1", 'a');
            boolean success = game.addPlayer(player1);

            if (success) {
                GameManager.addGame(game);
                player1.setGame(game);
                game.start();
                startTimer();

                return "New game created. Waiting for another player to join.";
            } else {
                return "Failed to create game. Maximum number of players reached.";
            }
        } else if (command.equalsIgnoreCase("join game")) {
            this.game = GameManager.getGameWithSinglePlayer();
            if (game == null)
                return "There is no game waiting for another player. You can create one.";

            Player player2 = new Player("Player2", 'b');
            boolean success = game.addPlayer(player2);
            if (success) {
                player2.setGame(game);
                game.start();
                startTimer();

                return "Joined the game successfully.";
            } else {
                return "Failed to join the game. Maximum number of players reached.";
            }
        } else if (command.startsWith("submit move")) {
            String[] tokens = command.split(" ");
            if (tokens.length != 4) {
                return "Invalid move command. Please provide a valid move.";
            }

            int row, col;
            try {
                row = Integer.parseInt(tokens[2]);
                col = Integer.parseInt(tokens[3]);
            } catch (NumberFormatException e) {
                return "Invalid move command. Please provide valid row and column numbers.";
            }

            Player currentPlayer = game.getCurrentPlayer();
            Player winner = game.makeMove(row, col);

            if (winner != null) {
                cancelTimer(); // Stop the timer if the game has ended
                return "Move submitted. Player " + currentPlayer.getName() + " wins!";
            } else {
                // Switch the turn to the next player and restart the timer
                 startTimer();
                return "Move submitted. It's now " + game.getCurrentPlayer().getName() + "'s turn.";
            }
        } else {
            return "Unknown command";
        }
    }
}
