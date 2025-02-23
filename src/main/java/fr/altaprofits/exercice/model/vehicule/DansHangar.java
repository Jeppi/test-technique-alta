package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.Hangar;

public class DansHangar implements EtatVehicule {

    @Override
    public boolean estStationne() {
        return true;
    }

    @Override
    public void entreDansHangar(Vehicule vehicule, Hangar hangar) {
        System.out.println("Le véhicule est déjà dans le hangar, il ne peut y entrer à nouveau.");
    }

    @Override
    public void sortDuHangar(Vehicule vehicule, Hangar hangar) {
        vehicule.setEtat(new HorsHangar());
        hangar.retire(vehicule);
    }
}
