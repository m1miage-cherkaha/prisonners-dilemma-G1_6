package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long> {
    
}