package fr.uga.l3miage.pc.prisonersdilemma.models;


import jakarta.persistence.*;
import javassist.expr.Instanceof;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partie /* implements Runnable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Joueur joueur1;
    @ManyToOne
    private Joueur joueur2;

    private int scoreJoueur1;
    private int scoreJoueur2;
    @Transient //=> champs temporaires non enregistrés en base
    private Strategie strategieJoueur1;
    @Transient
    private Strategie strategieJoueur2;
    private int nbTours;
    @OneToMany
    private List<Tour> Tours;
     public Partie(Joueur joueur1, Joueur joueur2, int nbTours){

     }
}
