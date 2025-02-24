package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.model.batiment.Section;
import fr.altaprofits.exercice.model.strategie.StrategieDeplacement;

// On veut savoir des différents éléments s'ils peuvent voler, rouler ou naviguer
public interface Element {
    Section<? extends Element> getSection();

    StrategieDeplacement getDeplacement();

    //  Choix simplifié, il faudrait traiter l'aspect transactionnel.
    void seDeplace(int x, int y);
}
