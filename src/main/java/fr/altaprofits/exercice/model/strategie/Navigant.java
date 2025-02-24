package fr.altaprofits.exercice.model.strategie;

import fr.altaprofits.exercice.commun.Point;

public class Navigant implements StrategieDeplacement {

    @Override
    public Point seDeplace(String descriptifEntite, Point depart, Point destination) {

        System.out.printf(descriptifEntite + ", navigue de la position %s vers %s\n",
                depart, destination);

        return destination;
    }
}
