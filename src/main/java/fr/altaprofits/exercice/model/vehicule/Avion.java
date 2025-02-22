package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;

public class Avion extends Vehicule{
    private static Integer idIndex = 0;

    public Avion() {
        super("A-" + ++idIndex);
    }

    public void seDeplace(int x, int y) {
        vole(new Point(x, y));
    }

    private void vole(Point destination) {
        System.out.printf("V�hicule de type avion (Ref : %s), se d�place de la position %s vers %s\n",
                reference, position, destination);
        position = destination;
    }
}
