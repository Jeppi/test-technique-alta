package fr.altaprofits.exercice.entreeSortie;

import fr.altaprofits.exercice.model.batiment.Section;
import fr.altaprofits.exercice.model.element.Element;
import fr.altaprofits.exercice.model.element.vehicule.Vehicule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class Impression {
    private static void imprimerDansConsole(Element<?> element) {
        System.out.println(element.getDescriptif());
    }

    private static void imprimerSectionDansFichier(Set<? extends Element<?>> elements, PrintStream printStream)  {
        for (Element<?> element : elements) {
            printStream.println(element.getDescriptif());
        }
    }

    public static void imprimerTousLesVehiculesDuHangarDansConsole(Map<Section<Vehicule>, Set<Vehicule>> sections) {
        for (Set<? extends Element<?>> vehicules : sections.values()) {
            vehicules.forEach(Impression::imprimerDansConsole);
        }
    }

    public static void imprimerTousLesVehiculesDuHangarDansFichier(File f, Map<Section<Vehicule>, Set<Vehicule>> sections) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(f));
        sections.values()
                .forEach(vehicules -> imprimerSectionDansFichier(vehicules, printStream));
    }
}
