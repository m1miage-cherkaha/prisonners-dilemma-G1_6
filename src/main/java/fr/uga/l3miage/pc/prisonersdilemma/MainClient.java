package fr.uga.l3miage.pc.prisonersdilemma;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MainClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 8001;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            String fromServer;

            // Recevoir les messages du serveur et interagir en conséquence
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Serveur: " + fromServer);

                // Si le serveur demande un choix de tour ou le nombre de tours, l'utilisateur répond
                if (fromServer.contains("Choisissez")) {
                    String choix = scanner.nextLine();
                    out.println(choix);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
