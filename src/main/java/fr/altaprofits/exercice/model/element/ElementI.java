package fr.altaprofits.exercice.model.element;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.batiment.Batiment;
import fr.altaprofits.exercice.model.batiment.Section;

public interface ElementI<T extends ElementI<T>> {
    String getDescriptif();

    String getReference();

    Point getPosition();

    <T extends ElementI<T>> Section<T> getSection();

    // Nécessaire pour gérer l'entrée du bâtiment en l'absence de transaction implémentée (Ticket)
    boolean estDansBatiment();

    boolean estVolant();

    boolean estRoulant();

    boolean estNavigant();

    void entre(Batiment<T> batiment);

    void sort(Batiment<T> batiment);
    //  Choix simplifié, il faudrait traiter l'aspect transactionnel.

    void seDeplace(int x, int y);
}
