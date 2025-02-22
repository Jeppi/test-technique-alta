package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;

public class JetSki extends Vehicule {
    private static Integer idIndex = 0;

    public JetSki() {
        super("J-" + ++idIndex);
    }

    public void seDeplace(int x, int y) {
        navigue(new Point(x, y));
    }

    private void navigue(Point destination) {
        System.out.printf("V�hicule de type jet-ski (Ref : %s), se d�place de la position %s vers %s\n",
                reference, position, destination);
        position = destination;
    }
}
