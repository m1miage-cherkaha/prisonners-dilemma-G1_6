package fr.uga.l3miage.pc.prisonersdilemma.repositories;

import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrategieRepository extends JpaRepository<Strategie, Long> {
}
