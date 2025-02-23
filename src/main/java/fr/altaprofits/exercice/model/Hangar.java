package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.vehicule.*;

import java.io.FileNotFoundException;
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

	public void ajoute(Vehicule vehicule) {
		sections.get(vehicule.getSection()).add(vehicule);
	}

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
		return nombreDeVehiculesDansPort() + nombreDeVehiculesDansAeroport() + nombreDeVehiculesDansGarage();
	}

	private static void imprimerDansConsole(Vehicule vehicule) {
		System.out.println(vehicule.getDescriptif());
	}

	private static void imprimerDansFichier(Vehicule vehicule, PrintStream printStream) throws FileNotFoundException {
		printStream.println(vehicule.getDescriptif());
	}


	public void imprimerTousLesVehiculesDuHangarDansConsole() {
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
