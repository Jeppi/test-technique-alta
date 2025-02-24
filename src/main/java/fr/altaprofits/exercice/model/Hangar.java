package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.vehicule.*;

import java.util.*;

import static fr.altaprofits.exercice.model.Section.*;

public class Hangar {

	// Position du hangar
	public final Point POSITION_HANGAR = new Point(0, 0);

	// Représente les différentes sections du hangar
	Map<Section, Set<Vehicule>> sections = new HashMap<>();

	public Map<Section, Set<Vehicule>> getSections() {
		return sections;
	}

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

}
