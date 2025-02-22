package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;

public class Bateau extends Vehicule {
    private static Integer idIndex = 0;

    public Bateau() {
        super("B-" + ++idIndex);
    }

    public void seDeplace(int x, int y) {
        navigue(new Point(x, y));
    }

    private void navigue(Point destination) {
        System.out.printf("V�hicule de type bateau (Ref : %s), se d�place de la position %s vers %s\n",
                reference, position, destination);
        position = destination;
    }
}
