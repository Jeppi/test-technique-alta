package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Roulant;

import static fr.altaprofits.exercice.model.Section.GARAGE;

public class Moto extends Vehicule {
    private static Integer idIndex = 0;

    public Moto() {
        super("M-" + ++idIndex, new Roulant(), GARAGE);
    }

}
