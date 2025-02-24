package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.Hangar;
import fr.altaprofits.exercice.model.SectionHangar;
import fr.altaprofits.exercice.model.vehicule.etat.EtatVehicule;

public interface Element {
    SectionHangar getSection();

    EtatVehicule getEtat();

    void setEtat(EtatVehicule etat);

    String getReference();

    Point getPosition();

    String getDescriptif();

    void setPosition(Point position);

    void entreDansHangar(Hangar hangar);

    void sortDuHangar(Hangar hangar);

    //  Choix simplifié, il faudrait traiter l'aspect transactionnel.
    void seDeplace(int x, int y);
}
