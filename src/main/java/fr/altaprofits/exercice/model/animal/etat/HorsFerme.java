package fr.altaprofits.exercice.model.animal.etat;

import fr.altaprofits.exercice.model.animal.Animal;
import fr.altaprofits.exercice.model.batiment.Ferme;

public class HorsFerme implements EtatAnimal {

    @Override
    public boolean estEntre() {
        return false;
    }

    @Override
    public void entre(Animal animal, Ferme ferme) {
        if (!ferme.POSITION_FERME.equals(animal.getPosition())) {
            System.out.printf("Le %s doit se déplacer pour rejoindre la ferme pour pouvoir y entrer.\n",
                    animal.getDescriptif());
            return;
        }
        animal.setEtat(new DansFerme());
        ferme.ajoute(animal);
        System.out.println(animal.getDescriptif() + " entre dans la ferme.");
    }

    @Override
    public void sort(Animal animal, Ferme ferme) {
        System.out.printf("Le %s n'est pas dans la ferme, il ne peut en sortir.\n",
                animal.getDescriptif());
    }
}
