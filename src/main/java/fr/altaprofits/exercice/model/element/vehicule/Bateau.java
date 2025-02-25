package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.element.strategie.Navigant;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.PORT;

public class Bateau extends Vehicule {
    private static Integer idIndex = 0;

    public Bateau() {
        super("B-" + ++idIndex, new Navigant(), PORT);
    }

}
