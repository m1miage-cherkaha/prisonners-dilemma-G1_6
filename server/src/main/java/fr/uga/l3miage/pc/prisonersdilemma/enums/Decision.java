package fr.uga.l3miage.pc.prisonersdilemma.enums;

public enum Decision {
    TRAHIR,
    COOPERER;

    static public Decision fromString(String decision) {
        if (decision.equals("TRAHIR")) {
            return TRAHIR;
        } else {
            return COOPERER;
        }
    }
}

