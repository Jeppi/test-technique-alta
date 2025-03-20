package fr.altaprofits.exercice.model.element;

import fr.altaprofits.exercice.model.environnement.Section;
import fr.altaprofits.exercice.model.element.strategie.Navigant;
import fr.altaprofits.exercice.model.element.strategie.Roulant;
import fr.altaprofits.exercice.model.element.strategie.StrategieDeplacement;
import fr.altaprofits.exercice.model.element.strategie.Volant;

import java.util.List;

import static fr.altaprofits.exercice.model.environnement.SectionHangar.*;

public enum TypeVehicule {
    AVION("A-", List.of(Volant.INSTANCE), List.of(AEROPORT)),
    BATEAU("B-", List.of(Navigant.INSTANCE), List.of(PORT)),
    HELICOPTERE("H-", List.of(Volant.INSTANCE), List.of(AEROPORT)),
    HYDRAVION("Hy-", List.of(Volant.INSTANCE), List.of(PORT, AEROPORT)),
    JETSKI("J-", List.of(Navigant.INSTANCE), List.of(PORT)),
    MOTO("M-", List.of(Roulant.INSTANCE), List.of(GARAGE)),
    VOITURE("V-", List.of(Roulant.INSTANCE), List.of(GARAGE));

    TypeVehicule(String reference, List<StrategieDeplacement> strategieDeplacements, List<Section<Vehicule>> sectionsAutorisees) {
        this.reference = reference;
        this.strategieDeplacements = strategieDeplacements;
        this.sectionsAutorisees = sectionsAutorisees;
    }

    private final String reference;
    private final List<StrategieDeplacement> strategieDeplacements;
    private final List<Section<Vehicule>> sectionsAutorisees;

    public String getReference() {
        return reference;
    }

    public List<StrategieDeplacement> getStrategieDeplacements() {
        return strategieDeplacements;
    }

    public List<Section<Vehicule>> getSectionsAutorisees() {
        return sectionsAutorisees;
    }
}
