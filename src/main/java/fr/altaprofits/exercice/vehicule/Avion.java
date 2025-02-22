package fr.altaprofits.exercice.vehicule;

import fr.altaprofits.exercice.Point;

public class Avion {
    private static Integer idIndex = 0;
    private final String refAvion;
    private Point position;

    public Avion() {
        position = new Point(0, 0);
        refAvion = "A-" + ++idIndex;
    }

    public void seDeplace(int x, int y) {
        vole(new Point(x, y));
    }

    private void vole(Point destination) {
        System.out.printf("V�hicule de type avion (Ref : %s), se d�place de la position %s vers %s\n", refAvion, position, destination);
        position = destination;
    }

    public String getReference() {
        return refAvion;
    }
}
