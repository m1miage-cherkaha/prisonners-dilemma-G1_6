package fr.uga.l3miage.pc.prisonersdilemma.services.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.StrategieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoopererStrategieService extends Strategie {
    @Autowired
    private StrategieRepository strategieRepository;

    public Decision adapterStrategie(){
        return Decision.COOPERER;
    }
}
