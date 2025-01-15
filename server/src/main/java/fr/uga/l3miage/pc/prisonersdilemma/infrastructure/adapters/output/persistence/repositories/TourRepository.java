package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {
}
