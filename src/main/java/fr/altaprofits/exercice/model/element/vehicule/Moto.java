package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.element.strategie.Roulant;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.GARAGE;

public class Moto extends Vehicule {
    private static Integer idIndex = 0;

    public Moto() {
        super("M-" + ++idIndex, new Roulant(), GARAGE);
    }

}
