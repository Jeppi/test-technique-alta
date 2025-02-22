package fr.altaprofits.exercice.vehicule;

import fr.altaprofits.exercice.Point;

public class Voiture {
    private static Integer idIndex = 0;
    private final String refVoiture;
    private Point position;

    public Voiture() {
        position = new Point(0, 0);
        refVoiture = "V-" + ++idIndex;
    }

    public void seDeplace(int x, int y) {
        roule(new Point(x, y));
    }

    private void roule(Point destination) {
        System.out.printf("V�hicule de type voiture (Ref : %s), se d�place de la position %s vers %s\n", refVoiture, position, destination);
        position = destination;
    }

    public String getReference() {
        return refVoiture;
    }
}
