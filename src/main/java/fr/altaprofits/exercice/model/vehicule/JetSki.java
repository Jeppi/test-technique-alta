package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.vehicule.strategie.Navigant;

import static fr.altaprofits.exercice.model.Section.PORT;

public class JetSki extends Vehicule {
    private static Integer idIndex = 0;

    public JetSki() {
        super("J-" + ++idIndex, new Navigant(), PORT);
    }

}
