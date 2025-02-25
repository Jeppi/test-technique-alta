package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.batiment.SectionHangar;
import fr.altaprofits.exercice.model.element.Element;
import fr.altaprofits.exercice.model.element.strategie.StrategieDeplacement;

public abstract class Vehicule extends Element<Vehicule> {


    protected Vehicule(String reference, StrategieDeplacement strategieDeplacement,
                       SectionHangar sectionDeStationnement) {
        super(strategieDeplacement, reference);
        section = sectionDeStationnement;
    }

}
