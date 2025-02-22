package fr.altaprofits.exercice.model.vehicule.strategie;

import fr.altaprofits.exercice.commun.Point;

public interface StrategieDeplacement {

    Point seDeplace(String descriptionEntite, Point depart, Point destination);

}
