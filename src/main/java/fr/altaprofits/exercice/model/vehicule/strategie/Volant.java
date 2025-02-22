package fr.altaprofits.exercice.model.vehicule.strategie;

import fr.altaprofits.exercice.commun.Point;

public class Volant implements StrategieDeplacement {

    @Override
    public Point seDeplace(String descriptifEntite, Point depart, Point destination) {

        System.out.printf(descriptifEntite + ", vole de la position %s vers %s\n",
                depart, destination);

        return destination;
    }
}
