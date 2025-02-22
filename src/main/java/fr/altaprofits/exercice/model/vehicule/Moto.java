package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Roulant;

public class Moto extends Vehicule {
    private static Integer idIndex = 0;

    public Moto() {
        super("M-" + ++idIndex, new Roulant());
    }

}
