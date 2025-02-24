package fr.altaprofits.exercice.model.batiment;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.animal.Animal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ferme implements Batiment<Animal, SectionFerme> {

	public final Point POSITION_FERME = new Point(0, 0);

	// Représente les différentes sections
	Map<SectionFerme, Set<Animal>> sections = new HashMap<>();

	@Override
	public Map<SectionFerme, Set<Animal>> getSections() {
		return sections;
	}

	public Ferme() {
		// Initialisation des différentes sections
		for (SectionFerme section : SectionFerme.values()) {
			sections.put(section, new HashSet<>());
		}
	}

	@Override
	public void ajoute(Animal animal) {
		if (!animal.getEtat().estEntre()) {
			System.out.printf("Pour ajouter le %s à la ferme, il faut faire appel à la méthode entreDansFerme().\n",
					animal.getDescriptif());
			return;
		}
		sections.get(animal.getSection()).add(animal);
	}

	// Doit être appelé par véhicule qui s'occupe de changer l'état de Véhicule
	@Override
	public void retire(Animal animal) {
		if (animal.getEtat().estEntre()) {
			System.out.printf("Pour retirer le %s de la ferme, il faut faire appel à la méthode sortDeLaFerme().\n",
					animal.getDescriptif());
			return;
		}
		sections.get(animal.getSection()).remove(animal);
	}

	public int nombreAnimaux(SectionFerme sectionFerme) {
		return sections.get(sectionFerme).size();
	}

	@Override
	public int nombreElementsDansBatiment() {
		return sections.values().stream()
				.map(Set::size)
				.reduce(Integer::sum)
				.orElse(0);
	}

}
