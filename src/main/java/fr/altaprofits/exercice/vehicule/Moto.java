package fr.altaprofits.exercice.vehicule;

import fr.altaprofits.exercice.Point;

public class Moto {
    private static Integer idIndex = 0;
    private final String refMoto;
    private Point position;

    public Moto() {
        position = new Point(0, 0);
        refMoto = "M-" + ++idIndex;
    }

    public void seDeplace(int x, int y) {
        roule(new Point(x, y));
    }

    private void roule(Point destination) {
        System.out.printf("V�hicule de type moto (Ref : %s), se d�place de la position %s vers %s\n", refMoto, position, destination);
        position = destination;
    }

    public String getReference() {
        return refMoto;
    }
}
