package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.element.strategie.Volant;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.AEROPORT;

public class Avion extends Vehicule{
    private static Integer idIndex = 0;

    public Avion() {
        super("A-" + ++idIndex, new Volant(), AEROPORT);
    }

}
