package fr.uga.l3miage.pc.prisonersdilemma.Common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Partie implements Runnable {
    private Joueur joueur1;
    private Joueur joueur2;

    private int scoreJoueur1;

    private int scoreJoueur2;

    private int nbTours = 5;// Par exemple, 5 tours par partie

    private List<Tour> tours;

    public Partie(Joueur joueur1, Joueur joueur2, int nbTours) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbTours = nbTours;
        this.scoreJoueur1=0;
        this.scoreJoueur2=0;
        this.tours = new ArrayList<>();
        for(int i=0;i<nbTours;i++){
            Tour t = new Tour();
            this.tours.add(t);
        }
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

                joueur1.envoyerMessage("Votre score est maintenant : " + scoreJoueur1);
                joueur2.envoyerMessage("Votre score est maintenant : " + scoreJoueur2);
            }

            afficherResultatFinal();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void calculerScore(String choixJoueur1, String choixJoueur2) {
        if (choixJoueur1.equals("c") && choixJoueur2.equals("c")) {
            // Coopération mutuelle
            scoreJoueur1 += (3);
            scoreJoueur2 +=(3);
        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("t")) {
            // Trahison mutuelle
            scoreJoueur1 += (1);
            scoreJoueur2 +=(1);
        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("c")) {
            // Joueur 1 trahit, Joueur 2 coopère
            scoreJoueur1 += (5);
            scoreJoueur2 +=(0);
        } else if (choixJoueur1.equals("c") && choixJoueur2.equals("t")) {
            // Joueur 1 coopère, Joueur 2 trahit
            scoreJoueur1 +=(0);
            scoreJoueur2 +=(5);
        }
    }

    private void afficherResultatFinal() {
        String messageFinalJ1 = "Résultat final : " + joueur1.getNom() + " : " + scoreJoueur1 + " points";
        String messageFinalJ2 = "Résultat final : " + joueur2.getNom() + " : " + scoreJoueur2 + " points";

        joueur1.envoyerMessage(messageFinalJ1);
        joueur2.envoyerMessage(messageFinalJ2);

        if (scoreJoueur1 > scoreJoueur2) {
            joueur1.envoyerMessage("Vous avez gagné !");
            joueur2.envoyerMessage("Vous avez perdu !");
        } else if (scoreJoueur2 > scoreJoueur1) {
            joueur2.envoyerMessage("Vous avez gagné !");
            joueur1.envoyerMessage("Vous avez perdu !");
        } else {
            joueur1.envoyerMessage("Match nul !");
            joueur2.envoyerMessage("Match nul !");
        }
    }
}
