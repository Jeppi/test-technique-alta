package fr.altaprofits.exercice.model.batiment;

import fr.altaprofits.exercice.model.element.vehicule.Vehicule;

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
