package fr.altaprofits.exercice.model.batiment;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.element.ElementI;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Batiment<T extends ElementI<T>> {

    public final Point POSITION = new Point(0, 0);

    // Représente les différentes sections du bâtiment
    Map<Section<T>, Set<T>> sections = new HashMap<>();

    public Map<Section<T>, Set<T>> getSections() {
        return sections;
    }

    // Doit être appelé par élément qui s'occupe de changer son propre état.
    // Je passe par l'état de l'élément pour gérer cela (solution à améliorer - Ticket).
    public void ajoute(T element) {
        // Si le véhicule n'est pas entré dans le hangar, on ne peut l'ajouter
        if (!element.estDansBatiment()) {
            System.out.printf("Pour ajouter le %s au hangar, il faut faire appel à la méthode entreDansHangar().\n",
                    element.getDescriptif());
            return;
        }
        sections.get(element.getSection()).add(element);
    }

    // Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
    public void retire(T element) {
        // Si le véhicule n'est pas sorti du hangar, on ne peut le retirer
        if (element.estDansBatiment()) {
            System.out.printf("Pour retirer le %s du bâtiment, il faut faire appel à la méthode sortDuBatiment().\n",
                    element.getDescriptif());
            return;
        }
        sections.get(element.getSection()).remove(element);
    }

    public int nombreElements(Section<T> section) {
        return sections.get(section).size();
    }

    public int nombreElementsDansBatiment() {
        return sections.values().stream()
                .map(Set::size)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int nombreElementsVolants() {
        return (int) sections.values().stream()
                .flatMap(Collection::stream)
                .filter(T::estVolant)
                .count();
    }

    public int nombreElementsRoulants() {
        return (int) sections.values().stream()
                .flatMap(Collection::stream)
                .filter(T::estRoulant)
                .count();
    }

    public int nombreElementsNavigants() {
        return (int) sections.values().stream()
                .flatMap(Collection::stream)
                .filter(T::estNavigant)
                .count();
    }
}
