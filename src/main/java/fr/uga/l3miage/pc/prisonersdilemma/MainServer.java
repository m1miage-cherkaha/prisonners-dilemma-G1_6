package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.Common.Jeu;
import fr.uga.l3miage.pc.prisonersdilemma.Common.Joueur;

import java.io.*;
import java.net.*;

public class MainServer {
    private static final int PORT = 8001;
    private static Joueur joueur1 = null;
    private static Joueur joueur2 = null;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur démarré sur le port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Un joueur s'est connecté.");

                if (joueur1 == null) {
                    joueur1 = new Joueur("Joueur 1", clientSocket);
                    System.out.println("Joueur 1 connecté !");


                } else if (joueur2 == null) {
                    joueur2 = new Joueur("Joueur 2", clientSocket);
                    System.out.println("Joueur 2 connecté !");

                    // Quand deux joueurs sont connectés, démarrer la partie dans un nouveau thread
                    new Thread(new Jeu(joueur1, joueur2)).start();

                    // Réinitialiser les joueurs pour permettre à de nouveaux joueurs de se connecter
                    joueur1 = null;
                    joueur2 = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
