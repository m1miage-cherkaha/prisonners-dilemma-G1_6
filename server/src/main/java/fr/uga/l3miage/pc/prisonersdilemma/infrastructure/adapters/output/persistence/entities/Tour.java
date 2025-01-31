package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pointJoueur1;
    private int pointJoueur2;
    private Decision decisionJoueur1;
    private Decision decisionJoueur2;
    private String status;

    @OneToOne
    @JoinColumn(name = "partie_id")
    Partie partie;
}
