package fr.altaprofits.exercice.entreeSortie;

import fr.altaprofits.exercice.model.SectionHangar;
import fr.altaprofits.exercice.model.vehicule.Vehicule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class Impression {
    private static void imprimerDansConsole(Vehicule vehicule) {
        System.out.println(vehicule.getDescriptif());
    }

    private static void imprimerSectionDansFichier(Set<Vehicule> vehicules, PrintStream printStream)  {
        for (Vehicule vehicule : vehicules) {
            printStream.println(vehicule.getDescriptif());
        }
    }

    public static void imprimerTousLesVehiculesDuHangarDansConsole(Map<SectionHangar, Set<Vehicule>> sections) {
        for (Set<Vehicule> vehicules : sections.values()) {
            vehicules.forEach(Impression::imprimerDansConsole);
        }
    }

    public static void imprimerTousLesVehiculesDuHangarDansFichier(File f, Map<SectionHangar, Set<Vehicule>> sections) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(f));
        sections.values()
                .forEach(vehicules -> imprimerSectionDansFichier(vehicules, printStream));
    }
}
