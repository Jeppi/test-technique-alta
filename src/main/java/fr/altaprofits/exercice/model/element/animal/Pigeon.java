package fr.altaprofits.exercice.model.element.animal;

import fr.altaprofits.exercice.model.element.strategie.Volant;

import static fr.altaprofits.exercice.model.batiment.SectionFerme.PIGEONNIER;

public class Pigeon extends Animal{
    private static Integer idIndex = 0;

    public Pigeon() {
        super("Pigeon-" + ++idIndex, new Volant(), PIGEONNIER);
    }

}
