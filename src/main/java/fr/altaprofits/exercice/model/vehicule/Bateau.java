package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Navigant;

import static fr.altaprofits.exercice.model.Section.PORT;

public class Bateau extends Vehicule {
    private static Integer idIndex = 0;

    public Bateau() {
        super("B-" + ++idIndex, new Navigant(), PORT);
    }

}
