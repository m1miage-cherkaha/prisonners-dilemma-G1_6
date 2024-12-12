package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.PartieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {

    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private PartieRepository partieRepository;

    // Créer un nouveau joueur
    public Joueur createJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    // Obtenir la liste de tous les joueurs
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    // Obtenir un joueur par son ID
    public Joueur getJoueurById(Long id) {
        return joueurRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Joueur non trouvé"));
    }

    public boolean leaveGame(Long id, String strategy) {
        boolean reussite = true;
        Joueur joueur = getJoueurById(id);
        joueur.setStrategie(TypeStrategie.valueOf(strategy));
        
        return reussite;
    }

    public int getScore(Long idPlayer) {
        return getJoueurById(idPlayer).getScore();
    }
    public void deleteAllJoueurs(){
        partieRepository.deleteAll();
        joueurRepository.deleteAll();
    }
}
