package fr.uga.l3miage.pc.prisonersdilemma.Common;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

public class Tour {

    private int pointJoueur1;
    private int pointJoueur2;
    private Decision decisionJoueur1;
    private Decision decisionJoueur2;

    private Partie partie;

    public Tour(){
        this.pointJoueur1=0;
        this.pointJoueur2=0;
        this.decisionJoueur1 = null;
        this.decisionJoueur2 = null;
    }

    public Tour(int pointJoueur1, int pointJoueur2, Decision decisionJoueur1, Decision decisionJoueur2){
        this.pointJoueur1 = pointJoueur1;
        this.pointJoueur2 = pointJoueur2;
        this.decisionJoueur1 = decisionJoueur1;
        this.decisionJoueur2 = decisionJoueur2;
    }

    public Tour(Decision decisionJoueur1, Decision decisionJoueur2){
        this.decisionJoueur1 = decisionJoueur1;
        this.decisionJoueur2 = decisionJoueur2;
        calculerPoints(decisionJoueur1,decisionJoueur2);
    }


    public void calculerPoints(Decision decisionJoueur1, Decision decisionJoueur2) {
        // Valeurs des gains selon l'énoncé
        int T = 5;  // Gain pour celui qui trahit quand l'autre coopère
        int D = 0;  // Gain pour celui qui coopère et se fait trahir
        int C = 3;  // Gain pour les deux quand ils coopèrent
        int P = 1;  // Gain pour les deux quand ils trahissent

        // Cas où les deux joueurs coopèrent [c, c]
        if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.COOPERER) {
            this.setPointJoueur1(C);
            this.setPointJoueur2(C);
        }
        // Cas où le joueur 1 trahit et le joueur 2 coopère [t, c]
        else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.COOPERER) {
            this.setPointJoueur1(T);
            this.setPointJoueur2(D);
        }
        // Cas où le joueur 1 coopère et le joueur 2 trahit [c, t]
        else if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.TRAHIR) {
            this.setPointJoueur1(D);
            this.setPointJoueur2(T);
        }
        // Cas où les deux joueurs trahissent [t, t]
        else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.TRAHIR) {
            this.setPointJoueur1(P);
            this.setPointJoueur2(P);
        }
    }
    public int getPointJoueur1() {return pointJoueur1;}
    public int getPointJoueur2() {return pointJoueur2;}
//    public boolean isTurn() { return turn;}

    public Decision getDecisionJoueur1() { return decisionJoueur1;}
    public Decision getDecisionJoueur2() { return decisionJoueur2;}

    public void setDecisionJoueur1(Decision decision){
        this.decisionJoueur1 = decision;
    }

    public void setDecisionJoueur2(Decision decision){
        this.decisionJoueur2 = decision;
    }

    public void setPointJoueur1(int point){
        this.pointJoueur1 = point;
    }

    public void setPointJoueur2(int point){
        this.pointJoueur2 = point;
    }

    public void setPartie(Partie partie){
        this.partie = partie;
    }

}
