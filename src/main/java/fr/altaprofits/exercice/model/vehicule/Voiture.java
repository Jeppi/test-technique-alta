package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.strategie.Roulant;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.GARAGE;

public class Voiture extends Vehicule {
    private static Integer idIndex = 0;

    public Voiture() {
        super("V-" + ++idIndex, new Roulant(), GARAGE);
    }

}
