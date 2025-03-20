package fr.altaprofits.exercice.model.environnement;

public class Environnement {
    private final Ferme ferme;
    private final Hangar hangar;

    public Environnement(Ferme ferme, Hangar hangar) {
        this.ferme = ferme;
        this.hangar = hangar;
    }

    public int nombreElementsVolants() {
        return ferme.nombreElementsVolants() + hangar.nombreElementsVolants();
    }

    public int nombreElementsRoulants() {
        return ferme.nombreElementsRoulants() + hangar.nombreElementsRoulants();
    }

    public int nombreElementsNavigants() {
        return ferme.nombreElementsNavigants() + hangar.nombreElementsNavigants();
    }
}
