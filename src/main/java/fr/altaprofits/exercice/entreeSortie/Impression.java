package fr.altaprofits.exercice.entreeSortie;

import fr.altaprofits.exercice.model.element.Element;
import fr.altaprofits.exercice.model.environnement.Section;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Impression {

    private static <T extends Element> void imprimerElements(Collection<T> elements, PrintStream printStream) {
        for (T element : elements) {
            printStream.println(element.getDescriptif());
        }
    }

    private static <T extends Element> void imprimerTousLesElementsDuBatiment(Map<Section<T>, Set<T>> sections, PrintStream printStream) {
        sections.values()
                .forEach(elements -> imprimerElements(elements, printStream));
    }

    public static <T extends Element> void imprimerTousLesElementsDuBatimentDansConsole(Map<Section<T>, Set<T>> sections) {
        imprimerTousLesElementsDuBatiment(sections, System.out);
    }

    public static <T extends Element> void imprimerTousLesElementsDuBatimentDansFichier(File f, Map<Section<T>, Set<T>> sections) throws FileNotFoundException {
        // try-with-ressource qui va fermer le PrintStream
        try (PrintStream printStream = new PrintStream(new FileOutputStream(f))) {
            imprimerTousLesElementsDuBatiment(sections, printStream);
        }
    }
}
