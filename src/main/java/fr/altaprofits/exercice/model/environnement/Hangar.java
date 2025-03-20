package fr.altaprofits.exercice.model.environnement;

import fr.altaprofits.exercice.model.element.Vehicule;

import java.util.*;

public class Hangar extends Batiment<Vehicule> {

	public Hangar() {
		super();
		// Initialisation des différentes sections
		for (SectionHangar section : SectionHangar.values()) {
			sections.put(section, new HashSet<>());
		}
	}

}
