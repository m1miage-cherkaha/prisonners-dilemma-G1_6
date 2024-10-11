package fr.uga.l3miage.pc.prisonersdilemma.common;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

public class Tour {

    private int pointJoueur1;
    private int pointJoueur2;
    private Decision decisionJoueur1;
    private Decision decisionJoueur2;


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
        // Valeurs Des gains selon l'énoncé
        int t = 5;  // Gain pour celui qui trahit quanD l'autre coopère
        int d = 0;  // Gain pour celui qui coopère et se fait trahir
        int c = 3;  // Gain pour les Deux quanD ils coopèrent
        int p = 1;  // Gain pour les Deux quanD ils trahissent

        // cas où les Deux joueurs coopèrent [c, c]
        if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.COOPERER) {
            this.setPointJoueur1(c);
            this.setPointJoueur2(c);
        }
        // cas où le joueur 1 trahit et le joueur 2 coopère [t, c]
        else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.COOPERER) {
            this.setPointJoueur1(t);
            this.setPointJoueur2(d);
        }
        // cas où le joueur 1 coopère et le joueur 2 trahit [c, t]
        else if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.TRAHIR) {
            this.setPointJoueur1(d);
            this.setPointJoueur2(t);
        }
        // cas où les Deux joueurs trahissent [t, t]
        else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.TRAHIR) {
            this.setPointJoueur1(p);
            this.setPointJoueur2(p);
        }
    }
    public int getPointJoueur1() {return pointJoueur1;}
    public int getPointJoueur2() {return pointJoueur2;}

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

}
