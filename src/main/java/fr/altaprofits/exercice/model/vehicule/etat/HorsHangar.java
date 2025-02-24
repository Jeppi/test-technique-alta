package fr.altaprofits.exercice.model.vehicule.etat;

import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.vehicule.Vehicule;

public class HorsHangar implements EtatVehicule {

    @Override
    public boolean estStationne() {
        return false;
    }

    @Override
    public void entreDansHangar(Vehicule vehicule, Hangar hangar) {
        if (!hangar.POSITION_HANGAR.equals(vehicule.getPosition())) {
            System.out.printf("Le %s doit se déplacer pour rejoindre le hangar pour pouvoir y entrer.\n",
                    vehicule.getDescriptif());
            return;
        }
        vehicule.setEtat(new DansHangar());
        hangar.ajoute(vehicule);
        System.out.println(vehicule.getDescriptif() + " entre dans le hangar.");
    }

    @Override
    public void sortDuHangar(Vehicule vehicule, Hangar hangar) {
        System.out.printf("Le %s n'est pas dans le hangar, il ne peut en sortir.\n",
                vehicule.getDescriptif());
    }
}
