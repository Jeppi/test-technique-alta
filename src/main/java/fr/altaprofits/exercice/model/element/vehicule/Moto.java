package fr.altaprofits.exercice.model.element.vehicule;

import fr.altaprofits.exercice.model.element.strategie.Roulant;

import java.util.concurrent.atomic.AtomicInteger;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.GARAGE;

public class Moto extends Vehicule {
    private static final AtomicInteger idIndex = new AtomicInteger();

    public Moto() {
        super("M-" + idIndex.incrementAndGet(), new Roulant(), GARAGE);
    }

}
