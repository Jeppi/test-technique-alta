package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.Hangar;
import fr.altaprofits.exercice.model.SectionHangar;
import fr.altaprofits.exercice.model.vehicule.etat.EtatVehicule;
import fr.altaprofits.exercice.model.vehicule.etat.HorsHangar;
import fr.altaprofits.exercice.model.vehicule.strategie.StrategieDeplacement;

public abstract class Vehicule implements Element {

    // Permet de spécifier le mode de déplacement propre à chaque type de véhicule
    protected final StrategieDeplacement deplacement;

    // Permet de spécifier la section dans laquelle stationner le véhicule
    protected SectionHangar section;

    // Permet de gérer la sortie-entrée dans le hangar ainsi que d'autoriser les déplacements
    protected EtatVehicule etat;

    // Identifiant
    protected final String reference;

    protected Point position;
    protected final String descriptif;


    @Override
    public SectionHangar getSection() {
        return section;
    }

    @Override
    public EtatVehicule getEtat() {
        return etat;
    }

    @Override
    public void setEtat(EtatVehicule etat) {
        this.etat = etat;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getDescriptif() {
        return descriptif;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    protected Vehicule(String reference, StrategieDeplacement strategieDeplacement,
                       SectionHangar sectionDeStationnement) {
        position = new Point(0, 0);
        this.reference = reference;
        deplacement = strategieDeplacement;
        section = sectionDeStationnement;
        etat = new HorsHangar();
        descriptif = String.format("Véhicule de type %s (Ref : %s)",
                getClass().getSimpleName(), reference);
    }

    @Override
    public void entreDansHangar(Hangar hangar) {
        etat.entreDansHangar(this, hangar);
    }

    @Override
    public void sortDuHangar(Hangar hangar) {
        etat.sortDuHangar(this, hangar);
    }

    //  Choix simplifié, il faudrait traiter l'aspect transactionnel.
    @Override
    public void seDeplace(int x, int y) {
        if (etat.estStationne()) {
            System.out.printf("Le %s est stationné, il doit être sorti du hangar pour pouvoir se déplacer.\n",
                    descriptif);
            return;
        }

        position = deplacement.seDeplace(descriptif, position, new Point(x, y));
    };
}
