package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.batiment.SectionHangar;
import fr.altaprofits.exercice.model.strategie.Volant;

import java.util.Set;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.AEROPORT;
import static fr.altaprofits.exercice.model.batiment.SectionHangar.PORT;

public class Hydravion extends Vehicule{
    private static Integer idIndex = 0;
    private final static Set<SectionHangar> SECTIONSAUTORISEES = Set.of(PORT, AEROPORT);

    // Par défaut tous les hydravions peuvent tous se poser sur l'eau.
    public Hydravion() {
        super("HY-" + ++idIndex, new Volant(), PORT);
    }

    // Si un hydravion arrive par la terre ou demande à se poser sur la terre (ou veut revenir au PORT)
    // Rmq : on choisit de ne pas pouvoir modifier la section s'il est déjà stationné (cohérence).
    // Inutile de généralisé cela aux autres Véhicules pour l'instant.
    public Hydravion setSection(SectionHangar section) {
        if (!SECTIONSAUTORISEES.contains(section)) {
            System.out.printf("Un hydravion ne peut stationner dans le %s, que dans le port ou l'aéroport",
                    section);
            return this;
        }
        if (etat.estStationne()) {
            System.out.println("On ne peut déplacer de section un hydravion une fois stationné," +
                    " il doit ressortir et rentrer à nouveau dans la nouvelle section.");
            return this;
        }
        this.section = section;
        return this;
    }
}
