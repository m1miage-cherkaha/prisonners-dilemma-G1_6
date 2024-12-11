package fr.uga.l3miage.pc.prisonersdilemma.models;

import jakarta.persistence.*;

import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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
