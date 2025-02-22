package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.Section;
import fr.altaprofits.exercice.model.vehicule.strategie.StrategieDeplacement;

public abstract class Vehicule {

    // Permet de spécifier le mode de déplacement propre à chaque type de véhicule
    protected final StrategieDeplacement deplacement;

    // Permet de spécifier la section dans laquelle stationner le véhicule
    protected final Section section;

    // Identifiant
    protected final String reference;
    protected Point position;

    public Section getSection() {
        return section;
    }

    public String getReference() {
        return reference;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    protected Vehicule(String reference, StrategieDeplacement strategieDeplacement,
                       Section sectionDeStationnement) {
        position = new Point(0, 0);
        this.reference = reference;
        deplacement = strategieDeplacement;
        section = sectionDeStationnement;
    }

    public void seDeplace(int x, int y) {
        String descriptifVehicule = String.format("Le Véhicule de type %s (Ref : %s)",
                getClass().getSimpleName(), reference);

        position = deplacement.seDeplace(descriptifVehicule, position, new Point(x, y));
    };
}
