package fr.uga.l3miage.pc.prisonersdilemma.models;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pointJoueur1;
    private int pointJoueur2;
    private Decision decisionJoueur1;
    private Decision decisionJoueur2;

//    private boolean turn; pas sur si on en a besoin
    @ManyToOne
    private Partie partie;

   public Long getTourId(){ return id;}

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
