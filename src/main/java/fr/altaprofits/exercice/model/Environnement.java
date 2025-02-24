package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.model.batiment.Ferme;
import fr.altaprofits.exercice.model.batiment.Hangar;

public class Environnement {
    private final Ferme ferme;
    private final Hangar hangar;

    public Environnement(Ferme ferme, Hangar hangar) {
        this.ferme = ferme;
        this.hangar = hangar;
    }

    int nombreElementsVolants() {
        return ferme.nombreElementsVolants() + hangar.nombreElementsVolants();
    }

    int nombreElementsRoulants() {
        return ferme.nombreElementsRoulants() + hangar.nombreElementsRoulants();
    }

    int nombreElementsNavigants() {
        return ferme.nombreElementsNavigants() + hangar.nombreElementsNavigants();
    }
}
