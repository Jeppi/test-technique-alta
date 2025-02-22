package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;

public class Voiture extends Vehicule {
    private static Integer idIndex = 0;

    public Voiture() {
        super("V-" + ++idIndex);
    }

    public void seDeplace(int x, int y) {
        roule(new Point(x, y));
    }

    private void roule(Point destination) {
        System.out.printf("V�hicule de type voiture (Ref : %s), se d�place de la position %s vers %s\n",
                reference, position, destination);
        position = destination;
    }
}
