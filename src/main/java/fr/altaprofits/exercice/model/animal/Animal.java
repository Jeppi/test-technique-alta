package fr.altaprofits.exercice.model.animal;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.Element;
import fr.altaprofits.exercice.model.animal.etat.EtatAnimal;
import fr.altaprofits.exercice.model.animal.etat.HorsFerme;
import fr.altaprofits.exercice.model.batiment.Ferme;
import fr.altaprofits.exercice.model.batiment.SectionFerme;
import fr.altaprofits.exercice.model.strategie.Navigant;
import fr.altaprofits.exercice.model.strategie.Roulant;
import fr.altaprofits.exercice.model.strategie.StrategieDeplacement;
import fr.altaprofits.exercice.model.strategie.Volant;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements Element {

    // Permet de spécifier le mode de déplacement
    protected StrategieDeplacement deplacementActif;

    // Un animal peut avoir plusieurs stratégies de déplacement
    // Contient en première position la stratégie par défaut via le constructeur.
    protected final List<StrategieDeplacement> deplacements = new ArrayList<>();

    // La sous classe peut ensuite ajouter des stratégies supplémentaires
    protected void ajouteStrategieDeplacement(StrategieDeplacement strategieDeplacement) {
        deplacements.add(strategieDeplacement);
    }

    // Elles pourront alors être activées
    public void setDeplacementActif(StrategieDeplacement strategieDeplacement) {
        if (!deplacements.contains(strategieDeplacement)) {
            System.out.println("Cette stratégie de déplacement ne peut être appliquée à cet animal.");
            return;
        }
        this.deplacementActif = strategieDeplacement;
    }

    // Permet de spécifier la section dans laquelle rentre l'animal
    protected SectionFerme section;

    // Permet de gérer la sortie-entrée dans la ferme ainsi que d'autoriser les déplacements
    protected EtatAnimal etat;

    // Identifiant
    protected final String reference;

    protected Point position;
    protected final String descriptif;

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
        deplacementActif = strategieDeplacement;
        deplacements.add(deplacementActif);
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

        position = deplacementActif.seDeplace(descriptif, position, new Point(x, y));
    }

    @Override
    public boolean estVolant() {
        return deplacements.stream()
                .anyMatch(deplacement -> deplacement instanceof Volant);
    }

    @Override
    public boolean estRoulant() {
        return deplacements.stream()
                .anyMatch(deplacement -> deplacement instanceof Roulant);
    }

    @Override
    public boolean estNavigant() {
        return deplacements.stream()
                .anyMatch(deplacement -> deplacement instanceof Navigant);
    }
}
