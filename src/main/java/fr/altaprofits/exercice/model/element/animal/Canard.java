package fr.altaprofits.exercice.model.element.animal;

import fr.altaprofits.exercice.model.element.strategie.Navigant;
import fr.altaprofits.exercice.model.element.strategie.Volant;

import java.util.concurrent.atomic.AtomicInteger;

import static fr.altaprofits.exercice.model.batiment.SectionFerme.ETANG;

public class Canard extends Animal{
    private static final AtomicInteger idIndex = new AtomicInteger();

    public Canard() {
        super("Canard-" + idIndex.incrementAndGet(), new Navigant(), ETANG);
        this.ajouteStrategieDeplacement(new Volant());
    }

}
