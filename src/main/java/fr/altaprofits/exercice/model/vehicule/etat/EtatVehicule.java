package fr.altaprofits.exercice.model.vehicule.etat;

import fr.altaprofits.exercice.model.Hangar;
import fr.altaprofits.exercice.model.vehicule.Vehicule;

public interface EtatVehicule {
    boolean estStationne();
    void entreDansHangar(Vehicule vehicule, Hangar hangar);
    void sortDuHangar(Vehicule vehicule, Hangar hangar);
}
