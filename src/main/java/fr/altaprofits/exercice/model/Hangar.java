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
	// Je passe par l'état de véhicule pour gérer cela (solution à améliorer - Ticket)
	public void ajoute(Vehicule vehicule) {
		// Si le véhicule n'est pas entré dans le hangar, on ne peut l'ajouter
		if (!vehicule.getEtat().estStationne()) {
			System.out.printf("Pour ajouter le %s au hangar, il faut faire appel à la méthode entreDansHangar().\n",
					vehicule.getDescriptif());
			return;
		}
		sections.get(vehicule.getSection()).add(vehicule);
	}

	// Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
	public void retire(Vehicule vehicule) {
		// Si le véhicule n'est pas sorti du hangar, on ne peut le retirer
		if (vehicule.getEtat().estStationne()) {
			System.out.printf("Pour retirer le %s au hangar, il faut faire appel à la méthode sortDuHangar().\n",
					vehicule.getDescriptif());
			return;
		}
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
