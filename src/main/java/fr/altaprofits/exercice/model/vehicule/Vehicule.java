package fr.altaprofits.exercice.model.vehicule;

import fr.altaprofits.exercice.commun.Point;

public abstract class Vehicule {
    protected final String reference;
    protected Point position;

    public String getReference() {
        return reference;
    }

    public Point getPosition() {
        return position;
    }

    protected Vehicule(String reference) {
        position = new Point(0, 0);
        this.reference = reference;
    }

    public abstract void seDeplace(int x, int y);
}
