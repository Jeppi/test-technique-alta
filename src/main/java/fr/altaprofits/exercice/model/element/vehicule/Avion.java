package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.element.strategie.Volant;

import java.util.concurrent.atomic.AtomicInteger;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.AEROPORT;

public class Avion extends Vehicule{
    private static final AtomicInteger idIndex = new AtomicInteger();

    public Avion() {
        super("A-" + idIndex.incrementAndGet(), new Volant(), AEROPORT);
    }

}
