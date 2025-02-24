package fr.altaprofits.exercice.model.animal;

import fr.altaprofits.exercice.model.strategie.Navigant;
import fr.altaprofits.exercice.model.strategie.Volant;

import static fr.altaprofits.exercice.model.batiment.SectionFerme.ETANG;

public class Canard extends Animal{
    private static Integer idIndex = 0;

    public Canard() {
        super("Canard-" + ++idIndex, new Navigant(), ETANG);
        this.ajouteStrategieDeplacement(new Volant());
    }

}
