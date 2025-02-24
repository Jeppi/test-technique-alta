package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.Element;
import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.batiment.SectionHangar;
import fr.altaprofits.exercice.model.strategie.Navigant;
import fr.altaprofits.exercice.model.strategie.Roulant;
import fr.altaprofits.exercice.model.strategie.Volant;
import fr.altaprofits.exercice.model.vehicule.etat.EtatVehicule;
import fr.altaprofits.exercice.model.vehicule.etat.HorsHangar;
import fr.altaprofits.exercice.model.strategie.StrategieDeplacement;

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

    public EtatVehicule getEtat() {
        return etat;
    }

    public void setEtat(EtatVehicule etat) {
        this.etat = etat;
    }

    public String getReference() {
        return reference;
    }

    public Point getPosition() {
        return position;
    }

    public String getDescriptif() {
        return descriptif;
    }

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

    public void entreDansHangar(Hangar hangar) {
        etat.entreDansHangar(this, hangar);
    }

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
    }

    @Override
    public boolean estVolant() {
        return deplacement instanceof Volant;
    }

    @Override
    public boolean estRoulant() {
        return deplacement instanceof Roulant;
    }

    @Override
    public boolean estNavigant() {
        return deplacement instanceof Navigant;
    }
}
