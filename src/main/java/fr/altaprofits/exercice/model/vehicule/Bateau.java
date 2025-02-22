package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Navigant;

public class Bateau extends Vehicule {
    private static Integer idIndex = 0;

    public Bateau() {
        super("B-" + ++idIndex, new Navigant());
    }

}
