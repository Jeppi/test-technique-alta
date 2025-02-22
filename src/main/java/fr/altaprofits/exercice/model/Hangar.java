package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.model.vehicule.*;
import fr.altaprofits.exercice.model.vehicule.strategie.Roulant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

import static fr.altaprofits.exercice.model.Section.*;

public class Hangar {

	// Représente les différentes sections du hangar
	Map<Section, Set<Vehicule>> sections = new HashMap<>();

	public Hangar() {
		// Initialisation des différentes sections
		for (Section section : Section.values()) {
			sections.put(section, new HashSet<>());
		}
	}

	public void entre(Vehicule vehicule) {
		sections.get(vehicule.getSection()).add(vehicule);
	}


	public int nombreDeVehiculesDansAeroport() {
		return sections.get(AEROPORT).size();
	}

	public int nombreDeVehiculesDansGarage() {
		return sections.get(GARAGE).size();
	}

	public int nombreDeVehiculesDansPort() {
		return sections.get(PORT).size();
	}

	public int nombreDeVehiculesDansHangar() {
		return nombreDeVehiculesDansPort() + nombreDeVehiculesDansAeroport() + nombreDeVehiculesDansGarage();
	}

	private static void imprimerDansConsole(Vehicule vehicule) {
		System.out.println("Véhicule de type "  + vehicule.getClass().getSimpleName());
		System.out.println(vehicule);
	}

	private static void imprimerDansFichier(Vehicule vehicule, PrintStream printStream) throws FileNotFoundException {
		printStream.println("Véhicule de type "  + vehicule.getClass().getSimpleName());
		printStream.println(vehicule);
	}


	public void imprimerToutDansConsole() {
		for (Set<Vehicule> vehicules : sections.values()) {
			vehicules.forEach(Hangar::imprimerDansConsole);
		}
	}

	/*public void imprimerToutDansFichier(File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		for (Set<Vehicule> vehicules : sections.values()) {
			vehicules.forEach(v -> imprimerDansFichier(v, printStream));
		}
	}*/
}
