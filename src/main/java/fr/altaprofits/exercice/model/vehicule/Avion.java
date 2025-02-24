package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Volant;

import static fr.altaprofits.exercice.model.SectionHangar.AEROPORT;

public class Avion extends Vehicule{
    private static Integer idIndex = 0;

    public Avion() {
        super("A-" + ++idIndex, new Volant(), AEROPORT);
    }

}
