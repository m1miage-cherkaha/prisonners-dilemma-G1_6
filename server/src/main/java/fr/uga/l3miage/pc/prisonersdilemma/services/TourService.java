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
  this.tourRepository = tourRepository;

 }

public Tour demarrerNouveauTour(Partie partie) {
  Tour tour = new Tour();

  // Réinitialiser les points des joueurs et les décisions
  tour.setPointJoueur1(0);
  tour.setPointJoueur2(0);
  tour.setDecisionJoueur1(null);
  tour.setDecisionJoueur2(null);


  // Sauvegarder le nouveau tour dans la base de données
  return tourRepository.save(tour);
 }
public Tour calculerPoints(Tour tour, Decision decisionJoueur1, Decision decisionJoueur2) {
  // Valeurs Des gains selon l'énoncé
  int t = 5;  // Gain pour celui qui trahit quanD l'autre coopère
  int d = 0;  // Gain pour celui qui coopère et se fait trahir
  int c = 3;  // Gain pour les Deux quanD ils coopèrent
  int p = 1;  // Gain pour les Deux quanD ils trahissent

  // cas où les Deux joueurs coopèrent [c, c]
  if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.COOPERER) {
   tour.setPointJoueur1(c);
   tour.setPointJoueur2(c);
  }
  // cas où le joueur 1 trahit et le joueur 2 coopère [t, c]
  else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.COOPERER) {
   tour.setPointJoueur1(t);
   tour.setPointJoueur2(d);
  }
  // cas où le joueur 1 coopère et le joueur 2 trahit [c, t]
  else if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.TRAHIR) {
   tour.setPointJoueur1(d);
   tour.setPointJoueur2(t);
  }
  // cas où les Deux joueurs trahissent [t, t]
  else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.TRAHIR) {
   tour.setPointJoueur1(p);
   tour.setPointJoueur2(p);
  }
  return tour;
 }










}
