package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.common.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.common.Partie;

import java.io.*;
import java.net.*;

public class MainServer {
    private static final int PORT = 8001;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur lancé et en attente de connexions...");

            // Attendre la connexion des deux joueurs
            Socket joueur1Socket = serverSocket.accept();
            System.out.println("Joueur 1 connecté.");
            PrintWriter outJoueur1 = new PrintWriter(joueur1Socket.getOutputStream(), true);
            BufferedReader inJoueur1 = new BufferedReader(new InputStreamReader(joueur1Socket.getInputStream()));

            // Le joueur 1 choisit le nombre de tours
            outJoueur1.println("Vous êtes le premier joueur. Choisissez le nombre de tours:");
            int nbTours = Integer.parseInt(inJoueur1.readLine());

            Socket joueur2Socket = serverSocket.accept();
            System.out.println("Joueur 2 connecté.");
            PrintWriter outJoueur2 = new PrintWriter(joueur2Socket.getOutputStream(), true);
            BufferedReader inJoueur2 = new BufferedReader(new InputStreamReader(joueur2Socket.getInputStream()));

            outJoueur1.println("Joueur 2 connecté. La partie commence.");
            outJoueur2.println("Vous êtes le deuxième joueur. La partie commence avec " + nbTours + " tours.");

            // Créer une partie
            Joueur joueur1 = new Joueur("Joueur 1", inJoueur1, outJoueur1);
            Joueur joueur2 = new Joueur("Joueur 2", inJoueur2, outJoueur2);
            Partie partie = new Partie(joueur1, joueur2, nbTours);

            // Lancer la partie dans un thread
            Thread partieThread = new Thread(partie);
            partieThread.start();
            partieThread.join(); // Attendre la fin de la partie

            // Fermer les connexions
            joueur1Socket.close();
            joueur2Socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
