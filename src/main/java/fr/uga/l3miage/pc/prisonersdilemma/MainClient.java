package fr.uga.l3miage.pc.prisonersdilemma;

import java.io.*;
import java.net.*;

public class MainClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8001;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println("Serveur : " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
