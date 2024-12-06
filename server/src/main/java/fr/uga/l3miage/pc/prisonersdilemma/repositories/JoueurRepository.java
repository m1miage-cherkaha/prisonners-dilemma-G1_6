package fr.uga.l3miage.pc.prisonersdilemma.repositories;

import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}
