package fr.altaprofits.exercice.model.element.strategie;

import fr.altaprofits.exercice.commun.Point;

public interface StrategieDeplacement {

    Point seDeplace(String descriptionEntite, Point depart, Point destination);

}
