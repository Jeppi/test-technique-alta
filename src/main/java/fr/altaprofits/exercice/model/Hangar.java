package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.vehicule.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

import static fr.altaprofits.exercice.model.Section.*;

public class Hangar {

	// Position du hangar
	public final Point POSITION_HANGAR = new Point(0, 0);

	// Représente les différentes sections du hangar
	Map<Section, Set<Vehicule>> sections = new HashMap<>();

	public Hangar() {
		// Initialisation des différentes sections
		for (Section section : Section.values()) {
			sections.put(section, new HashSet<>());
		}
	}

	// Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
	public void ajoute(Vehicule vehicule) {
		sections.get(vehicule.getSection()).add(vehicule);
	}

	// Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
	public void retire(Vehicule vehicule) {
		sections.get(vehicule.getSection()).remove(vehicule);
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
		return sections.values().stream()
				.map(Set::size)
				.reduce(Integer::sum)
				.orElse(0);
	}

	private static void imprimerDansConsole(Vehicule vehicule) {
		System.out.println(vehicule.getDescriptif());
	}

	private static void imprimerSectionDansFichier(Set<Vehicule> vehicules, PrintStream printStream)  {
		for (Vehicule vehicule : vehicules) {
			printStream.println(vehicule.getDescriptif());
		}
	}


	public void imprimerTousLesVehiculesDuHangarDansConsole() {
		for (Set<Vehicule> vehicules : sections.values()) {
			vehicules.forEach(Hangar::imprimerDansConsole);
		}
	}

	public void imprimerTousLesVehiculesDuHangarDansFichier(File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		sections.values()
				.forEach(vehicules -> imprimerSectionDansFichier(vehicules, printStream));
	}
}
