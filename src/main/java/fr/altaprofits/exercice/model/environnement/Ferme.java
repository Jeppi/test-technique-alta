package fr.altaprofits.exercice.model.environnement;

import fr.altaprofits.exercice.model.element.Animal;

import java.util.*;

public class Ferme extends Batiment<Animal> {

	public Ferme() {
		super();
		// Initialisation des différentes sections
		for (SectionFerme section : SectionFerme.values()) {
			sections.put(section, new HashSet<>());
		}
	}

}
