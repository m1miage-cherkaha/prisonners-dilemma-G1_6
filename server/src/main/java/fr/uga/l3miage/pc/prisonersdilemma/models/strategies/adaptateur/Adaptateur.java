package fr.uga.l3miage.pc.prisonersdilemma.models.strategies.adaptateur;

import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.StrategieFactory;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.BaseStrategie;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

public class Adaptateur implements Strategie {
    // Decision.cooperer =>true, Decision.trahir => false
    //A adapter : Décision => type PartieJouee = {boolean choixJoueur, boolean choixAutreJoueur, private int resultat}
    private BaseStrategie strategie;

    public Adaptateur(StrategieFactory strategieFactory, int idStrategie) {
        this.strategie = strategieFactory.createStrategie(idStrategie);
    }


    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {

        List<PartieJouee> partieJouees = new ArrayList<>();
        for(Decision decision : coupsAdversaire){
            partieJouees.add(convertirDecision(decision));
        }
        boolean choix = this.strategie.jouer(partieJouees);
        return choix ? Decision.COOPERER : Decision.TRAHIR;
        
    }
    private PartieJouee convertirDecision(Decision decision){
        if(decision == Decision.COOPERER){
            return new PartieJouee(true, true, 0);
        }else{
            return new PartieJouee(true, false, 0);
        }
    }
    
}
