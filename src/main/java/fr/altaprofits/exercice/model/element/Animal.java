package fr.altaprofits.exercice.model.element;

import fr.altaprofits.exercice.model.environnement.Section;

import java.util.concurrent.atomic.AtomicInteger;

public class Animal extends Element {

    private static final AtomicInteger idIndex = new AtomicInteger();

    private final TypeAnimal typeAnimal;

    // Section que l'élément va rejoindre dans le bâtiment.
    protected Section<Animal> section;

    public Section<Animal> getSectionActive() {
        return section;
    }

    public Animal(TypeAnimal typeAnimal) {
        super(typeAnimal.getStrategieDeplacements(), typeAnimal.getReference() + idIndex.incrementAndGet());
        this.typeAnimal = typeAnimal;
        section = typeAnimal.getSection();
    }
}
