package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.model.Hangar;

public interface EtatVehicule {
    boolean estStationne();
    void entreDansHangar(Vehicule vehicule, Hangar hangar);
    void sortDuHangar(Vehicule vehicule, Hangar hangar);
}
