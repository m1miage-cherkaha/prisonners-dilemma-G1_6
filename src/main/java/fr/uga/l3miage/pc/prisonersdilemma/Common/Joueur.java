package fr.uga.l3miage.pc.prisonersdilemma.Common;

import java.io.*;
import java.net.Socket;

public class Joueur {
    private String nom;
    private int score;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Joueur(String nom, Socket socket) throws IOException {
        this.nom = nom;
        this.score = 0;
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void ajouterPoints(int points) {
        this.score += points;
    }

    public String faireChoix() throws IOException {
        out.println("Choisissez 'c' pour coopérer ou 't' pour trahir : ");
        System.out.println("here");
        String choix = in.readLine();
        System.out.println("choix : " + choix);
        while (!choix.equals("c") && !choix.equals("t")) {
            out.println("Entrée invalide. Veuillez choisir 'c' pour coopérer ou 't' pour trahir : ");
            choix = in.readLine();
        }
        return choix;
    }

    public void envoyerMessage(String message) {
        out.println(message);
    }
}
