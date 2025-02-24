package fr.altaprofits.exercice.model.animal;

import fr.altaprofits.exercice.model.Etat;
import fr.altaprofits.exercice.model.batiment.Ferme;

public interface EtatAnimal extends Etat {
    boolean estEntre();
    void entre(Animal animal, Ferme ferme);
    void sort(Animal animal, Ferme ferme);
}
