package fr.altaprofits.exercice.model.element.strategie;

import fr.altaprofits.exercice.commun.Point;

public enum Volant implements StrategieDeplacement {
    INSTANCE;

    @Override
    public Point seDeplace(String descriptifEntite, Point depart, Point destination) {

        System.out.printf(descriptifEntite + ", vole de la position %s vers %s\n",
                depart, destination);

        return destination;
    }
}
