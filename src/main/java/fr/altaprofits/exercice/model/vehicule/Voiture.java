package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Roulant;

import static fr.altaprofits.exercice.model.Section.GARAGE;

public class Voiture extends Vehicule {
    private static Integer idIndex = 0;

    public Voiture() {
        super("V-" + ++idIndex, new Roulant(), GARAGE);
    }

}
