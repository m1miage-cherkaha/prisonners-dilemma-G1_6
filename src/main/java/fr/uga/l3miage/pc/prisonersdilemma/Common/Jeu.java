package fr.uga.l3miage.pc.prisonersdilemma.Common;

import java.io.IOException;
import java.io.PrintWriter;

public class Jeu implements Runnable {
    private Joueur joueur1;
    private Joueur joueur2;
    private int nbTours = 5;  // Par exemple, 5 tours par partie

    public Jeu(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    @Override
    synchronized public void run() {
        try {
            for (int i = 1; i <= nbTours; i++) {
                joueur1.envoyerMessage("Tour " + i + " de la partie.");
                joueur2.envoyerMessage("Tour " + i + " de la partie.");

                String choixJoueur1 = joueur1.faireChoix();
                String choixJoueur2 = joueur2.faireChoix();

                joueur1.envoyerMessage(joueur2.getNom() + " a choisi : " + (choixJoueur2.equals("c") ? "coopérer" : "trahir"));
                joueur2.envoyerMessage(joueur1.getNom() + " a choisi : " + (choixJoueur1.equals("c") ? "coopérer" : "trahir"));

                calculerScore(choixJoueur1, choixJoueur2);

                joueur1.envoyerMessage("Votre score est maintenant : " + joueur1.getScore());
                joueur2.envoyerMessage("Votre score est maintenant : " + joueur2.getScore());
            }

            afficherResultatFinal();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calculerScore(String choixJoueur1, String choixJoueur2) {
        if (choixJoueur1.equals("c") && choixJoueur2.equals("c")) {
            // Coopération mutuelle
            joueur1.ajouterPoints(3);
            joueur2.ajouterPoints(3);
        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("t")) {
            // Trahison mutuelle
            joueur1.ajouterPoints(1);
            joueur2.ajouterPoints(1);
        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("c")) {
            // Joueur 1 trahit, Joueur 2 coopère
            joueur1.ajouterPoints(5);
            joueur2.ajouterPoints(0);
        } else if (choixJoueur1.equals("c") && choixJoueur2.equals("t")) {
            // Joueur 1 coopère, Joueur 2 trahit
            joueur1.ajouterPoints(0);
            joueur2.ajouterPoints(5);
        }
    }

    private void afficherResultatFinal() {
        String messageFinalJ1 = "Résultat final : " + joueur1.getNom() + " : " + joueur1.getScore() + " points";
        String messageFinalJ2 = "Résultat final : " + joueur2.getNom() + " : " + joueur2.getScore() + " points";

        joueur1.envoyerMessage(messageFinalJ1);
        joueur2.envoyerMessage(messageFinalJ2);

        if (joueur1.getScore() > joueur2.getScore()) {
            joueur1.envoyerMessage("Vous avez gagné !");
            joueur2.envoyerMessage("Vous avez perdu !");
        } else if (joueur2.getScore() > joueur1.getScore()) {
            joueur2.envoyerMessage("Vous avez gagné !");
            joueur1.envoyerMessage("Vous avez perdu !");
        } else {
            joueur1.envoyerMessage("Match nul !");
            joueur2.envoyerMessage("Match nul !");
        }
    }
}
