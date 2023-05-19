package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;

        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String request;
            String response;

            while (true) {
                System.out.print("\n \nThe commands are : \n"
                        +  "1. create game -> You create a new game and you need to wait another player to join your game.\n"
                        +  "2. join game -> You join a game, in case there is a player who wait an opponent. \n"
                        +  "3. submit move row column -> You move a piece on the row and column give. \n"
                        +  "4. exit -> You exit the app.\n"
                        +  "Type the name of the command: ")
                ;

                request = keyboardInput.readLine();

                if (request.equalsIgnoreCase("exit")) {
                    break;
                }

                out.println(request);
                response = in.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}

