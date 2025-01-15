package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.adaptateur;
import fr.uga.l3miage.pc.prisonersdilemma.classes.PartieJouee;
import fr.uga.l3miage.pc.prisonersdilemma.classes.StrategieFactory;
import fr.uga.l3miage.pc.prisonersdilemma.classes.strategies.BaseStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

public class Adaptateur implements Strategie {
    private BaseStrategie strategie;

    public Adaptateur(TypeStrategie typeStrategie) {

        Logger logger = Logger.getLogger(Adaptateur.class);

        switch (typeStrategie) {
            case TOUJOURS_COOPERER:
                this.strategie = StrategieFactory.createStrategie(16);
            break;
            case TOUJOURS_TRAHIR :
                this.strategie = StrategieFactory.createStrategie(17);
            break;
            default:
            logger.error("Strategie non reconnue, statégie par défaut : toujours coopérer");
                this.strategie = StrategieFactory.createStrategie(16);
                break;
        }
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
