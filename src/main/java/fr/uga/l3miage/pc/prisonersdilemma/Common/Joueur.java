package fr.uga.l3miage.pc.prisonersdilemma.Common;

import java.io.*;
import java.net.Socket;

public class Joueur {
    private String nom;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Joueur(String nom, Socket socket) throws IOException {
        this.nom = nom;
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public Joueur(String nom, BufferedReader in, PrintWriter out) {
        this.nom = nom;
        this.in = in;
        this.out = out;
    }

    public String getNom() {
        return nom;
    }

    public String faireChoix() throws IOException {
        this.envoyerMessage("Choisissez 'c' pour coopérer ou 't' pour trahir : ");
        out.flush();
        String choix = in.readLine();
        System.out.println("choix : " + choix);
        while (!choix.equals("c") && !choix.equals("t")) {
            this.envoyerMessage("Entrée invalide. Veuillez choisir 'c' pour coopérer ou 't' pour trahir : ");
            out.flush();
            choix = in.readLine();
        }
        return choix;
    }

    public void envoyerMessage(String message) {
        out.println(message);
    }
}
