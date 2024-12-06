package fr.uga.l3miage.pc.prisonersdilemma.models;


import javax.persistence.*;
import javassist.expr.Instanceof;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Joueur joueur1;
    @ManyToOne
    private Joueur joueur2;
    private int nbTours;
    @OneToMany
    private List<Tour> Tours;
     public Partie(Joueur joueur1, Joueur joueur2, int nbTours){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbTours = nbTours;
     }
}
