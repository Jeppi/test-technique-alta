package fr.altaprofits.exercice.model.element.animal;

import fr.altaprofits.exercice.model.element.strategie.Roulant;

import static fr.altaprofits.exercice.model.batiment.SectionFerme.ETABLE;

public class Vache extends Animal{
    private static Integer idIndex = 0;

    public Vache() {
        super("Vache-" + ++idIndex, new Roulant(), ETABLE);
    }

}
