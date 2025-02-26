package fr.altaprofits.exercice.model.element;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.batiment.Batiment;
import fr.altaprofits.exercice.model.batiment.Section;
import fr.altaprofits.exercice.model.element.etat.Etat;
import fr.altaprofits.exercice.model.element.etat.HorsBatiment;
import fr.altaprofits.exercice.model.element.strategie.Navigant;
import fr.altaprofits.exercice.model.element.strategie.Roulant;
import fr.altaprofits.exercice.model.element.strategie.StrategieDeplacement;
import fr.altaprofits.exercice.model.element.strategie.Volant;

import java.util.ArrayList;
import java.util.List;

public abstract class Element<T extends Element<T>> implements ElementI<T> {

    // Section que l'élément va rejoindre dans le bâtiment.
    protected Section<T> section;

    public Section<T> getSection() {
        return section;
    }

    // Caractéristiques
    protected final String reference;
    protected Point position;
    protected final String descriptif;

    @Override
    public String getDescriptif() {
        return descriptif;
    }
    @Override
    public String getReference() {
        return reference;
    }
    @Override
    public Point getPosition() {
        return position;
    }

    // ****

    // Un élément peut avoir plusieurs stratégies de déplacement
    // Contient en première position la stratégie par défaut via le constructeur.
    protected final List<StrategieDeplacement> deplacements = new ArrayList<>();

    // Permet de spécifier le mode de déplacement
    protected StrategieDeplacement deplacementActif;

    // La sous classe peut ensuite ajouter des stratégies supplémentaires (constructeur, peut être rendu publique).
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

    // ****

    // Permet de gérer la sortie-entrée dans la ferme ainsi que d'autoriser les déplacements
    protected Etat<T> etat;

    public void setEtat(Etat<T> etat) {
        this.etat = etat;
    }

    public Element(StrategieDeplacement strategieDeplacement, String reference) {
        deplacementActif = strategieDeplacement;
        ajouteStrategieDeplacement(deplacementActif);
        this.reference = reference;
        position = new Point(0, 0);
        descriptif = String.format("Element de type %s (Ref : %s)",
                getClass().getSimpleName(), reference);
        etat = new HorsBatiment<>();
    }

    // Nécessaire pour gérer l'entrée du bâtiment en l'absence de transaction implémentée (Ticket)
    @Override
    public boolean estDansBatiment() {
        return etat.estDansBatiment();
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


    @Override
    public void entre(Batiment<T> batiment) {
        etat.entreDansBatiment((T) this, batiment);
    }

    @Override
    public void sort(Batiment<T> batiment) {
        etat.sortDuBatiment((T) this, batiment);
    }

    //  Choix simplifié, il faudrait traiter l'aspect transactionnel.
    @Override
    public void seDeplace(int x, int y) {
        if (etat.estDansBatiment()) {
            System.out.printf("Le %s est à l'intérieur, il doit sortir pour pouvoir se déplacer.\n",
                    descriptif);
            return;
        }

        position = deplacementActif.seDeplace(descriptif, position, new Point(x, y));
    }
}
