package fr.altaprofits.exercice.model.element.animal;

import fr.altaprofits.exercice.model.element.strategie.Volant;

import java.util.concurrent.atomic.AtomicInteger;

import static fr.altaprofits.exercice.model.batiment.SectionFerme.PIGEONNIER;

public class Pigeon extends Animal{
    private static final AtomicInteger idIndex = new AtomicInteger();

    public Pigeon() {
        super("Pigeon-" + idIndex.incrementAndGet(), new Volant(), PIGEONNIER);
    }

}
