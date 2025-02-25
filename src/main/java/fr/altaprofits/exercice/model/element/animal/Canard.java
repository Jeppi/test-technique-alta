package fr.altaprofits.exercice.model.element.animal;

import fr.altaprofits.exercice.model.element.strategie.Navigant;
import fr.altaprofits.exercice.model.element.strategie.Volant;

import static fr.altaprofits.exercice.model.batiment.SectionFerme.ETANG;

public class Canard extends Animal{
    private static Integer idIndex = 0;

    public Canard() {
        super("Canard-" + ++idIndex, new Navigant(), ETANG);
        this.ajouteStrategieDeplacement(new Volant());
    }

}
