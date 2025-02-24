package fr.altaprofits.exercice.model.batiment;

import fr.altaprofits.exercice.model.Element;

import java.util.Map;
import java.util.Set;

public interface Batiment<T extends Element, S extends Section<T>> {
    Map<S, Set<T>> getSections();

    // Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
    // Je passe par l'état de véhicule pour gérer cela (solution à améliorer - Ticket)
    void ajoute(T element);

    // Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
    void retire(T element);

    int nombreElements(S section);

    int nombreElementsDansBatiment();
}
