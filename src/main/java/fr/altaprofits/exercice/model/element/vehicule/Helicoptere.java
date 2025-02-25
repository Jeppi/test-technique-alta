package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.element.strategie.Volant;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.AEROPORT;

public class Helicoptere extends Vehicule {
    private static Integer idIndex = 0;

    public Helicoptere() {
        super("H-" + ++idIndex, new Volant(), AEROPORT);
    }

}
