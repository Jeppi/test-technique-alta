package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Volant;

public class Helicoptere extends Vehicule {
    private static Integer idIndex = 0;

    public Helicoptere() {
        super("H-" + ++idIndex, new Volant());
    }

}
