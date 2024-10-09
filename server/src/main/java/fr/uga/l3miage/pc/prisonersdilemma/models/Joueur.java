package fr.uga.l3miage.pc.prisonersdilemma.models;


import jakarta.persistence.*;

@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int score;
    private String choix;

    public Joueur() {}

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getChoix() { return choix; }
    public void setChoix(String choix) { this.choix = choix; }
    public void ajouterPoints(int points) { this.score += points; }}
