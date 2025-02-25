package fr.altaprofits.exercice.model.element.strategie;

import fr.altaprofits.exercice.commun.Point;

public class Roulant implements StrategieDeplacement {

    @Override
    public Point seDeplace(String descriptifEntite, Point depart, Point destination) {

        System.out.printf(descriptifEntite + ", roule de la position %s vers %s\n",
                depart, destination);

        return destination;
    }
}
