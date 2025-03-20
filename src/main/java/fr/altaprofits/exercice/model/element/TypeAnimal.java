package fr.altaprofits.exercice.model.element;

import fr.altaprofits.exercice.model.environnement.Section;
import fr.altaprofits.exercice.model.element.strategie.Navigant;
import fr.altaprofits.exercice.model.element.strategie.Roulant;
import fr.altaprofits.exercice.model.element.strategie.StrategieDeplacement;
import fr.altaprofits.exercice.model.element.strategie.Volant;

import java.util.List;

import static fr.altaprofits.exercice.model.environnement.SectionFerme.*;

public enum TypeAnimal {
    CANARD("Canard-", List.of(Navigant.INSTANCE, Volant.INSTANCE), ETANG),
    VACHE("Vache-", List.of(Roulant.INSTANCE), ETABLE),
    PIGEON("Canard-", List.of(Volant.INSTANCE), PIGEONNIER);

    TypeAnimal(String reference, List<StrategieDeplacement> strategieDeplacements, Section<Animal> section) {
        this.reference = reference;
        this.strategieDeplacements = strategieDeplacements;
        this.section = section;
    }

    private final String reference;
    private final List<StrategieDeplacement> strategieDeplacements;
    private final Section<Animal> section;

    public String getReference() {
        return reference;
    }

    public List<StrategieDeplacement> getStrategieDeplacements() {
        return strategieDeplacements;
    }

    public Section<Animal> getSection() {
        return section;
    }
}
