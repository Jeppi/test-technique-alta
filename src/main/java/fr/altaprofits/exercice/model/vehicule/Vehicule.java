package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.vehicule.strategie.StrategieDeplacement;

public abstract class Vehicule {

    protected final StrategieDeplacement deplacement;

    protected final String reference;
    protected Point position;

    public String getReference() {
        return reference;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    protected Vehicule(String reference, StrategieDeplacement strategieDeplacement) {
        position = new Point(0, 0);
        this.reference = reference;
        deplacement = strategieDeplacement;
    }

    public void seDeplace(int x, int y) {
        String descriptifVehicule = String.format("Le Véhicule de type %s (Ref : %s)",
                getClass().getSimpleName(), reference);

        position = deplacement.seDeplace(descriptifVehicule, position, new Point(x, y));
    };
}
