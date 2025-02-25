package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.element.strategie.Navigant;

import java.util.concurrent.atomic.AtomicInteger;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.PORT;

public class Bateau extends Vehicule {
    private static final AtomicInteger idIndex = new AtomicInteger();

    public Bateau() {
        super("B-" + idIndex.incrementAndGet(), new Navigant(), PORT);
    }

}
