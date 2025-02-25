package fr.altaprofits.exercice.model.element.animal;

import fr.altaprofits.exercice.model.element.strategie.Roulant;

import java.util.concurrent.atomic.AtomicInteger;

import static fr.altaprofits.exercice.model.batiment.SectionFerme.ETABLE;

public class Vache extends Animal{
    private static final AtomicInteger idIndex = new AtomicInteger();

    public Vache() {
        super("Vache-" + idIndex.incrementAndGet(), new Roulant(), ETABLE);
    }

}
