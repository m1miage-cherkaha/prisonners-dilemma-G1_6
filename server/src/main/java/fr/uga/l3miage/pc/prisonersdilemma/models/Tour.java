package fr.uga.l3miage.pc.prisonersdilemma.models;

import org.springframework.data.repository.query.parser.Part;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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

    @OneToOne
    @JoinColumn(name = "partie_id")
    Partie partie;
}
