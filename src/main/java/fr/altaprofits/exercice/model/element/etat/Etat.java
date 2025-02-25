package fr.altaprofits.exercice.model.element.etat;

import fr.altaprofits.exercice.model.element.Element;
import fr.altaprofits.exercice.model.batiment.Batiment;

public interface Etat<T extends Element<T>>  {
    boolean estDansBatiment();
    void entreDansBatiment(T element, Batiment<T> batiment);
    void sortDuBatiment(T element, Batiment<T> batiment);
}
