package fr.altaprofits.exercice.vehicule;

import fr.altaprofits.exercice.Point;

public class JetSki {
    private static Integer idIndex = 0;
    private final String refJetSki;
    private Point position;

    public JetSki() {
        position = new Point(0, 0);
        refJetSki = "J-" + ++idIndex;
    }

    public void seDeplace(int x, int y) {
        navigue(new Point(x, y));
    }

    private void navigue(Point destination) {
        System.out.printf("V�hicule de type jet-ski (Ref : %s), se d�place de la position %s vers %s\n", refJetSki, position, destination);
        position = destination;
    }

    public String getReference() {
        return refJetSki;
    }
}
