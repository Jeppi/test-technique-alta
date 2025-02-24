package fr.altaprofits.exercice.model.vehicule.etat;

import fr.altaprofits.exercice.model.Batiment;
import fr.altaprofits.exercice.model.Hangar;
import fr.altaprofits.exercice.model.Section;
import fr.altaprofits.exercice.model.SectionHangar;
import fr.altaprofits.exercice.model.vehicule.Element;
import fr.altaprofits.exercice.model.vehicule.Vehicule;

public interface EtatVehicule extends Etat {
    boolean estStationne();
    void entreDansHangar(Vehicule vehicule, Hangar hangar);
    void sortDuHangar(Vehicule vehicule, Hangar hangar);
}
