package fr.altaprofits.exercice.model.element.etat;

import fr.altaprofits.exercice.model.element.Element;
import fr.altaprofits.exercice.model.batiment.Batiment;

public class DansBatiment<T extends Element<T>> implements Etat<T> {

    @Override
    public boolean estDansBatiment() {
        return true;
    }

    @Override
    public void entreDansBatiment(T element, Batiment<T> batiment) {
        System.out.printf("Le %s est déjà dans le bâtiment, il ne peut y entrer à nouveau.\n",
                element.getDescriptif());
    }

    @Override
    public void sortDuBatiment(T element, Batiment<T> batiment) {
        element.setEtat(new HorsBatiment<T>());
        batiment.retire(element);
        System.out.println(element.getDescriptif() + " sort du hangar.");
    }
}
