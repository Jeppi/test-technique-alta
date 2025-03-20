package fr.altaprofits.exercice.model.element;

import fr.altaprofits.exercice.model.environnement.Section;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Vehicule extends Element {

    private static final AtomicInteger idIndex = new AtomicInteger();

    private final TypeVehicule typeVehicule;

    // Sections que le véhicule peut rejoindre, par exemple PORT et AEROPORT pour l'hydravion
    private final List<Section<Vehicule>> sectionsAutorisees;

    // Section que l'élément va rejoindre dans le bâtiment.
    private Section<Vehicule> sectionActive;

    public Section<Vehicule> getSectionActive() {
        return sectionActive;
    }

    public Vehicule setSectionActive(Section<Vehicule> section) {
        if (!sectionsAutorisees.contains(section)) {
            System.out.printf("Ce Véhicule %s n'est pas autorisé à stationer dans cette section : %s", descriptif, section.toString());
            return this;
        }
        // Si le véhicule est déjà stationné, il doit sortir pour pouvoir changer de section
        if (getEstDansBatiment()) {
            System.out.printf("Ce Véhicule %s doit ressortir pour pouvoir rentrer dans une nouvelle section", descriptif);
            return this;
        }
        this.sectionActive = section;
        return this;
    }

    public Vehicule(TypeVehicule typeVehicule) {
        super(typeVehicule.getStrategieDeplacements(), typeVehicule.getReference()
                + idIndex.incrementAndGet());
        this.typeVehicule = typeVehicule;
        sectionsAutorisees = List.copyOf(typeVehicule.getSectionsAutorisees());
        sectionActive = sectionsAutorisees.getFirst();
    }

}
