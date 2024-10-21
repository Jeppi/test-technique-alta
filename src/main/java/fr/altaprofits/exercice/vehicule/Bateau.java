package fr.altaprofits.exercice.vehicule;

import fr.altaprofits.exercice.Point;

public class Bateau {
    private static Integer idIndex = 0;
    private final String refBateau;
    private Point position;

    public Bateau() {
        position = new Point(0, 0);
        refBateau = "B-" + ++idIndex;
    }

    public void seDeplace(int x, int y) {
        navigue(new Point(x, y));
    }

    private void navigue(Point destination) {
        System.out.printf("V�hicule de type bateau (Ref : %s), se d�place de la position %s vers %s\n", refBateau, position, destination);
        position = destination;
    }
}
