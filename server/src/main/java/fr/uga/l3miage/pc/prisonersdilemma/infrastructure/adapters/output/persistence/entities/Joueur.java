package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.TypeStrategie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int score; // pas sur qu'on garde ça
    private TypeStrategie strategie;
    
    public void ajouterPoints(int points) {
        this.score += points;
    }

    public Joueur(String nom){
        this.nom = nom;
    }

}
