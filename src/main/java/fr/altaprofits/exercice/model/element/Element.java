package fr.altaprofits.exercice.model.element;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.environnement.Section;
import fr.altaprofits.exercice.model.element.strategie.Navigant;
import fr.altaprofits.exercice.model.element.strategie.Roulant;
import fr.altaprofits.exercice.model.element.strategie.StrategieDeplacement;
import fr.altaprofits.exercice.model.element.strategie.Volant;

import java.util.List;

public abstract class Element  {

    // Caractéristiques
    protected final String reference;
    protected Point position;
    protected final String descriptif;

    public String getDescriptif() {
        return descriptif;
    }
    public String getReference() {
        return reference;
    }
    public Point getPosition() {
        return position;
    }

    // ****

    // Un élément peut avoir plusieurs stratégies de déplacement
    // Contient en première position la stratégie par défaut.
    protected final List<StrategieDeplacement> deplacements;

    // Permet de spécifier le mode de déplacement actif
    protected StrategieDeplacement deplacementActif;

    // Elles pourront alors être activées
    public void setDeplacementActif(StrategieDeplacement strategieDeplacement) {
        if (!deplacements.contains(strategieDeplacement)) {
            System.out.println("Cette stratégie de déplacement ne peut être appliquée à cet animal.");
            return;
        }
        this.deplacementActif = strategieDeplacement;
    }

    // ****
    // L'élément est ou non dans un batîment
    private boolean estDansBatiment = false;

    public boolean getEstDansBatiment() {
        return estDansBatiment;
    }

    public void setEstDansBatiment(boolean estDansBatiment) {
        this.estDansBatiment = estDansBatiment;
    }

    public Element(List<StrategieDeplacement> deplacements, String reference) {
        this.deplacements = deplacements;
        deplacementActif = deplacements.getFirst();
        this.reference = reference;
        position = new Point(0, 0);
        descriptif = String.format("Element de type %s (Ref : %s)",
                getClass().getSimpleName(), reference);
    }

    public boolean estVolant() {
        return deplacements.stream()
                .anyMatch(deplacement -> deplacement instanceof Volant);
    }

    public boolean estRoulant() {
        return deplacements.stream()
                .anyMatch(deplacement -> deplacement instanceof Roulant);
    }

    public boolean estNavigant() {
        return deplacements.stream()
                .anyMatch(deplacement -> deplacement instanceof Navigant);
    }

    public void seDeplace(int x, int y) {
        if (estDansBatiment) {
            System.out.printf("Le %s est à l'intérieur, il doit sortir pour pouvoir se déplacer.\n",
                    descriptif);
            return;
        }

        position = deplacementActif.seDeplace(descriptif, position, new Point(x, y));
    }

    public abstract Section<? extends Element> getSectionActive();
}
