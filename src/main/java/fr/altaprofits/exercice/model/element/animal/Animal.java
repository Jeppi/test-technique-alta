package fr.altaprofits.exercice.model.element.animal;

import fr.altaprofits.exercice.model.batiment.SectionFerme;
import fr.altaprofits.exercice.model.element.Element;
import fr.altaprofits.exercice.model.element.strategie.StrategieDeplacement;

public abstract class Animal extends Element<Animal> {

    protected Animal(String reference, StrategieDeplacement strategieDeplacement,
                     SectionFerme sectionFerme) {
        super(strategieDeplacement, reference);
        section = sectionFerme;
    }
}
