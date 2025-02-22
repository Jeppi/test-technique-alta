package fr.altaprofits.exercice.vehicule;

import fr.altaprofits.exercice.Point;

public class Helicoptere {
    private static Integer idIndex = 0;
    private final String refHelico;
    private Point position;

    public Helicoptere() {
        position = new Point(0, 0);
        refHelico = "H-" + ++idIndex;
    }

    public void seDeplace(int x, int y) {
        vole(new Point(x, y));
    }

    private void vole(Point destination) {
        System.out.printf("V�hicule de type h�licopt�re (Ref : %s), se d�place de la position %s vers %s\n", refHelico, position, destination);
        position = destination;
    }

    public String getReference() {
        return refHelico;
    }
}
