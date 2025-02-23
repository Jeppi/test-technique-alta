package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.Hangar;

public class HorsHangar implements EtatVehicule {

    @Override
    public boolean estStationne() {
        return false;
    }

    @Override
    public void entreDansHangar(Vehicule vehicule, Hangar hangar) {
        if (!hangar.POSITION_HANGAR.equals(vehicule.getPosition())) {
            System.out.println("Le véhicule doit se déplacer pour rejoindre le hangar pour pouvoir y entrer.");
            return;
        }
        vehicule.setEtat(new DansHangar());
        hangar.ajoute(vehicule);
    }

    @Override
    public void sortDuHangar(Vehicule vehicule, Hangar hangar) {
        System.out.println("Le véhicule n'est pas dans le hangar, il ne peut en sortir.");
    }
}
