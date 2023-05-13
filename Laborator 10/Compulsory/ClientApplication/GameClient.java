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
                System.out.print("Enter a command (or 'exit' to quit): ");
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

