package fr.altaprofits.exercice.model.environnement;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.element.Element;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Batiment<T extends Element> {

    public final Point POSITION = new Point(0, 0);

    // Représente les différentes sections du bâtiment
    Map<Section<T>, Set<T>> sections = new HashMap<>();

    public Map<Section<T>, Set<T>> getSections() {
        return sections;
    }

    public void faitEntrer(T element) {
        if (element.getEstDansBatiment()) {
            System.out.printf("Le %s est déjà dans le batîment\n", element.getDescriptif());
            return;
        }
        if (!POSITION.equals(element.getPosition())) {
            System.out.printf("Le %s doit se déplacer pour rejoindre le bâtiment pour pouvoir y entrer.\n",
                    element.getDescriptif());
            return;
        }
        // On ajoute l'élément à sa section et on met à jour estDansBatiment :
        element.setEstDansBatiment(true);
        sections.get(element.getSectionActive()).add(element);
    }

    public void faitSortir(T element) {
        if (!element.getEstDansBatiment()) {
            System.out.printf("Le %s n'est pas dans le batîment\n", element.getDescriptif());
            return;
        }
        // On sort l'élément de sa section et on met à jour estDansBatiment :
        sections.get(element.getSectionActive()).remove(element);
        element.setEstDansBatiment(false);
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
