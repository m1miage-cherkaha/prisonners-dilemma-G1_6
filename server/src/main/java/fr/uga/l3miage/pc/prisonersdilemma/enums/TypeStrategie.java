package fr.uga.l3miage.pc.prisonersdilemma.enums;

public enum TypeStrategie {
    TOUJOURS_COOPERER,
    TOUJOURS_TRAHIR,
    DONNANT_DONNANT,
    RANCUNIER,
    ALEATOIRE;
    public static TypeStrategie fromString(String strategie) {
        if (strategie.equals("TOUJOURS_COOPERER")) {
            return TOUJOURS_COOPERER;
        } else if (strategie.equals("TOUJOURS_TRAHIR")) {
            return TOUJOURS_TRAHIR;
        } else if (strategie.equals("DONNANT_DONNANT")) {
            return DONNANT_DONNANT;
        } else if (strategie.equals("RANCUNIER")) {
            return RANCUNIER;
        } else {
            return ALEATOIRE;
        }
    }

}
