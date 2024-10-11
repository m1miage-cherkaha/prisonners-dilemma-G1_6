package fr.uga.l3miage.pc.prisonersdilemma.common;

import java.io.*;


public class Joueur {
    private String nom;
    private BufferedReader in;
    private PrintWriter out;


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
