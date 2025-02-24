package fr.altaprofits.exercice.model.vehicule.etat;

import fr.altaprofits.exercice.model.Etat;
import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.vehicule.Vehicule;

public interface EtatVehicule extends Etat {
    boolean estStationne();
    void entreDansHangar(Vehicule vehicule, Hangar hangar);
    void sortDuHangar(Vehicule vehicule, Hangar hangar);
}
