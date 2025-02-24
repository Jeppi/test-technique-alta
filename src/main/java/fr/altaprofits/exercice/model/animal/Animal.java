package fr.altaprofits.exercice.model.animal;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.Element;
import fr.altaprofits.exercice.model.batiment.Ferme;
import fr.altaprofits.exercice.model.batiment.SectionFerme;
import fr.altaprofits.exercice.model.strategie.StrategieDeplacement;

public abstract class Animal implements Element {

    // Permet de spécifier le mode de déplacement
    protected final StrategieDeplacement deplacement;

    // Permet de spécifier la section dans laquelle rentre l'animal
    protected SectionFerme section;

    // Permet de gérer la sortie-entrée dans la ferme ainsi que d'autoriser les déplacements
    protected EtatAnimal etat;

    // Identifiant
    protected final String reference;

    protected Point position;
    protected final String descriptif;

    @Override
    public StrategieDeplacement getDeplacement() {
        return deplacement;
    }

    @Override
    public SectionFerme getSection() {
        return section;
    }

    public EtatAnimal getEtat() {
        return etat;
    }

    public void setEtat(EtatAnimal etat) {
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

    protected Animal(String reference, StrategieDeplacement strategieDeplacement,
                     SectionFerme sectionFerme) {
        position = new Point(0, 0);
        this.reference = reference;
        deplacement = strategieDeplacement;
        section = sectionFerme;
        etat = new HorsFerme();
        descriptif = String.format("Animal d'espèce %s (Ref : %s)",
                getClass().getSimpleName(), reference);
    }

    public void entre(Ferme ferme) {
        etat.entre(this, ferme);
    }

    public void sort(Ferme ferme) {
        etat.sort(this, ferme);
    }

    //  Choix simplifié, il faudrait traiter l'aspect transactionnel.
    @Override
    public void seDeplace(int x, int y) {
        if (etat.estEntre()) {
            System.out.printf("Le %s est à l'intérieur, il doit sortir pour pouvoir se déplacer.\n",
                    descriptif);
            return;
        }

        position = deplacement.seDeplace(descriptif, position, new Point(x, y));
    };
}
