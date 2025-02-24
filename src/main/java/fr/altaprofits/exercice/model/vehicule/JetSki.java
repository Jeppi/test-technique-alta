package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.strategie.Navigant;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.PORT;

public class JetSki extends Vehicule {
    private static Integer idIndex = 0;

    public JetSki() {
        super("J-" + ++idIndex, new Navigant(), PORT);
    }

}
