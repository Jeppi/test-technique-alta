package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.model.batiment.Section;

// On veut savoir des différents éléments s'ils peuvent voler, rouler ou naviguer
public interface Element {
    Section<? extends Element> getSection();

    // Ajout fonctionnel de la méthode de nombre d'éléments par type de déplacements
    boolean estVolant();
    boolean estRoulant();
    boolean estNavigant();

    //  Choix simplifié, il faudrait traiter l'aspect transactionnel.
    void seDeplace(int x, int y);
}
