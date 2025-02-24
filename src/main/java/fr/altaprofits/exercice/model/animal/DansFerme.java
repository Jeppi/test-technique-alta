package fr.altaprofits.exercice.model.animal;

import fr.altaprofits.exercice.model.batiment.Ferme;

public class DansFerme implements EtatAnimal {

    @Override
    public boolean estEntre() {
        return true;
    }

    @Override
    public void entre(Animal animal, Ferme ferme) {
        System.out.printf("Le %s est déjà dans la ferme, il ne peut y entrer à nouveau.\n", animal.getDescriptif());
    }

    @Override
    public void sort(Animal animal, Ferme ferme) {
        animal.setEtat(new HorsFerme());
        ferme.retire(animal);
        System.out.println(animal.getDescriptif() + " sort de la ferme.");
    }
}
