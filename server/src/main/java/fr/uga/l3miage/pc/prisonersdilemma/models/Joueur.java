package fr.uga.l3miage.pc.prisonersdilemma.models;


import jakarta.persistence.*;
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
    private int score;
    private String choix;

    public void ajouterPoints(int points) {
        this.score += points;
    }
}
