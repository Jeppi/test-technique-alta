package fr.altaprofits.exercice.model.batiment;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.vehicule.*;

import java.util.*;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.*;

public class Hangar implements Batiment<Vehicule, SectionHangar> {

	// Position du hangar
	public final Point POSITION_HANGAR = new Point(0, 0);

	// Représente les différentes sections du hangar
	Map<SectionHangar, Set<Vehicule>> sections = new HashMap<>();

	@Override
	public Map<SectionHangar, Set<Vehicule>> getSections() {
		return sections;
	}

	public Hangar() {
		// Initialisation des différentes sections
		for (SectionHangar section : SectionHangar.values()) {
			sections.put(section, new HashSet<>());
		}
	}

	// Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
	// Je passe par l'état de véhicule pour gérer cela (solution à améliorer - Ticket)
	@Override
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
	@Override
	public void retire(Vehicule vehicule) {
		// Si le véhicule n'est pas sorti du hangar, on ne peut le retirer
		if (vehicule.getEtat().estStationne()) {
			System.out.printf("Pour retirer le %s au hangar, il faut faire appel à la méthode sortDuHangar().\n",
					vehicule.getDescriptif());
			return;
		}
		sections.get(vehicule.getSection()).remove(vehicule);
	}

	@Override
	public int nombreElements(SectionHangar sectionHangar) {
		return sections.get(sectionHangar).size();
	}

	@Override
	public int nombreElementsDansBatiment() {
		return sections.values().stream()
				.map(Set::size)
				.reduce(Integer::sum)
				.orElse(0);
	}

	@Override
	public int nombreElementsVolants() {
		return 0;
	}

	@Override
	public int nombreElementsRoulants() {
		return 0;
	}

	@Override
	public int nombreElementsNavigants() {
		return 0;
	}
}
