package fr.altaprofits.exercice.model.vehicule.etat;

import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.vehicule.Vehicule;

public class DansHangar implements EtatVehicule {

    @Override
    public boolean estStationne() {
        return true;
    }

    @Override
    public void entreDansHangar(Vehicule vehicule, Hangar hangar) {
        System.out.printf("Le %s est déjà dans le hangar, il ne peut y entrer à nouveau.\n", vehicule.getDescriptif());
    }

    @Override
    public void sortDuHangar(Vehicule vehicule, Hangar hangar) {
        vehicule.setEtat(new HorsHangar());
        hangar.retire(vehicule);
        System.out.println(vehicule.getDescriptif() + " sort du hangar.");
    }
}
