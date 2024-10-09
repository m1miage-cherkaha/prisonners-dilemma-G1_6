package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.PartieRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

 private final TourRepository tourRepository;

 @Autowired
 public TourService(TourRepository tourRepository){
  this.tourRepository =tourRepository;

 }

 public Tour demarrerNouveauTour(Partie partie) {
  Tour tour = new Tour();

  // Réinitialiser les points des joueurs et les décisions
  tour.setPointJoueur1(0);
  tour.setPointJoueur2(0);
  tour.setDecisionJoueur1(null);
  tour.setDecisionJoueur2(null);

  // Associer le tour à la partie
  tour.setPartie(partie);

  // Sauvegarder le nouveau tour dans la base de données
  return tourRepository.save(tour);
 }
 public Tour calculerPoints(Decision decisionJoueur1, Decision decisionJoueur2,Tour tour) {
  // Valeurs des gains selon l'énoncé
  int T = 5;  // Gain pour celui qui trahit quand l'autre coopère
  int D = 0;  // Gain pour celui qui coopère et se fait trahir
  int C = 3;  // Gain pour les deux quand ils coopèrent
  int P = 1;  // Gain pour les deux quand ils trahissent

  // Cas où les deux joueurs coopèrent [c, c]
  if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.COOPERER) {
   tour.setPointJoueur1(C);
   tour.setPointJoueur2(C);
  }
  // Cas où le joueur 1 trahit et le joueur 2 coopère [t, c]
  else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.COOPERER) {
   tour.setPointJoueur1(T);
   tour.setPointJoueur2(D);
  }
  // Cas où le joueur 1 coopère et le joueur 2 trahit [c, t]
  else if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.TRAHIR) {
   tour.setPointJoueur1(D);
   tour.setPointJoueur2(T);
  }
  // Cas où les deux joueurs trahissent [t, t]
  else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.TRAHIR) {
    tour.setPointJoueur1(P);
    tour.setPointJoueur2(P);
  }
  return tourRepository.save(tour);
 }

 public Tour jouer(Decision decisionJoueur1, Decision decisionJoueur2, Tour tour) {
  tour.setDecisionJoueur1(decisionJoueur1);
  tour.setDecisionJoueur2(decisionJoueur2);


  return calculerPoints(decisionJoueur1, decisionJoueur2, tour);
 }










}
