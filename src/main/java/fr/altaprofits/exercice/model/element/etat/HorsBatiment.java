package fr.altaprofits.exercice.model.element.etat;

import fr.altaprofits.exercice.model.element.Element;
import fr.altaprofits.exercice.model.batiment.Batiment;

public class HorsBatiment<T extends Element<T>> implements Etat<T> {

    @Override
    public boolean estDansBatiment() {
        return false;
    }

    @Override
    public void entreDansBatiment(T element, Batiment<T> batiment) {
        if (!batiment.POSITION.equals(element.getPosition())) {
            System.out.printf("Le %s doit se déplacer pour rejoindre le bâtiment pour pouvoir y entrer.\n",
                    element.getDescriptif());
            return;
        }
        element.setEtat(new DansBatiment<T>());
        batiment.ajoute(element);
        System.out.println(element.getDescriptif() + " entre dans le bâtiment.");
    }

    @Override
    public void sortDuBatiment(T element, Batiment<T> batiment) {
        System.out.printf("Le %s n'est pas dans le bâtiment, il ne peut en sortir.\n",
                element.getDescriptif());
    }
}
