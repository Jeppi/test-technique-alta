package fr.altaprofits.exercice;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.animal.Animal;
import fr.altaprofits.exercice.model.animal.Canard;
import fr.altaprofits.exercice.model.animal.Pigeon;
import fr.altaprofits.exercice.model.animal.Vache;
import fr.altaprofits.exercice.model.batiment.Ferme;
import fr.altaprofits.exercice.model.batiment.SectionFerme;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FermeTest {

    Ferme ferme = new Ferme();

    Vache vache1 = new Vache();
    Pigeon pigeon1 = new Pigeon();
    Canard canard1 = new Canard();

    Vache vache2 = new Vache();
    Pigeon pigeon2 = new Pigeon();
    Canard canard2 = new Canard();

    Vache vache3 = new Vache();
    Pigeon pigeon3 = new Pigeon();
    Canard canard3 = new Canard();




    @Test
    void entre() {

        vache1.entre(ferme);
        pigeon1.entre(ferme);
        canard1.entre(ferme);
        vache2.entre(ferme);
        pigeon2.entre(ferme);
        canard2.entre(ferme);

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(6);

        // On refait entrer
        pigeon1.entre(ferme);
        vache2.entre(ferme);

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(6);

        // On ajoute un nouveau
        new Canard().entre(ferme);

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(7);

    }

    @Test
    void entreKO() {

        vache1.seDeplace(5, 12);
        pigeon1.seDeplace(17, 13);
        canard1.seDeplace(10, 30);
        vache2.seDeplace(25, 55);
        pigeon2.seDeplace(23, 11);
        canard2.seDeplace(3, 9);

        // les animaux ne se trouvent plus à l'entrée de la ferme
        vache1.entre(ferme);
        pigeon1.entre(ferme);
        canard1.entre(ferme);
        vache2.entre(ferme);
        pigeon2.entre(ferme);
        canard2.entre(ferme);

        // Aucun ne peut entrer
        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(0);

    }

    @Test
    void nombreAnimauxParSection() {

        vache1.entre(ferme);
        pigeon1.entre(ferme);
        canard1.entre(ferme);
        vache2.entre(ferme);
        pigeon2.entre(ferme);
        canard2.entre(ferme);
        canard3.entre(ferme);
        vache3.entre(ferme);
        new Vache().entre(ferme);

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(9);

        assertThat(ferme.nombreElements(SectionFerme.PIGEONNIER)).isEqualTo(2);
        assertThat(ferme.nombreElements(SectionFerme.ETABLE)).isEqualTo(4);
        assertThat(ferme.nombreElements(SectionFerme.ETANG)).isEqualTo(3);

    }

    @Test
    void idUniquePourChaqueAnimal() {

        Set<Animal> animaux = Set.of(vache1, vache2, pigeon2, pigeon1, pigeon3, canard1,
                canard2, canard3, new Vache());

        Set<String> references = animaux.stream()
                .map(Animal::getReference)
                .collect(Collectors.toSet());

        // On a bien le même nombre d'id distinct que de véhicules
        assertThat(references.size()).isEqualTo(animaux.size());

        // NB : le code ne garanti pas l'unicité si l'on crée deux entités du même type au même moment (à voir si c'est dans le scope)
    }

    @Test
    void vehiculesSeDeplacent() {

        vache1.seDeplace(5, 12);
        vache2.seDeplace(17, 13);
        canard1.seDeplace(10, 30);
        canard1.seDeplace(30, 60);
        canard2.seDeplace(25, 55);
        pigeon1.seDeplace(23, 11);
        
        assertThat(vache1.getPosition()).isEqualTo(new Point(5, 12));
        assertThat(vache2.getPosition()).isEqualTo(new Point(17, 13));
        assertThat(canard1.getPosition()).isEqualTo(new Point(30, 60));
        assertThat(canard2.getPosition()).isEqualTo(new Point(25, 55));
        assertThat(pigeon1.getPosition()).isEqualTo(new Point(23, 11));
        
    }

    @Test
    void vehiculesSeDeplacentKO() {

        // On fait entrer les animaux dans la ferme, ils ne peuvent plus se déplacer avant d'en sortir
        vache1.entre(ferme);
        vache2.entre(ferme);
        canard1.entre(ferme);
        canard2.entre(ferme);
        pigeon1.entre(ferme);

        vache1.seDeplace(5, 12);
        vache2.seDeplace(17, 13);
        canard1.seDeplace(10, 30);
        canard1.seDeplace(30, 60);
        canard2.seDeplace(25, 55);
        pigeon1.seDeplace(23, 11);

        assertThat(vache1.getPosition()).isEqualTo(ferme.POSITION_FERME);
        assertThat(vache2.getPosition()).isEqualTo(ferme.POSITION_FERME);
        assertThat(canard1.getPosition()).isEqualTo(ferme.POSITION_FERME);
        assertThat(canard2.getPosition()).isEqualTo(ferme.POSITION_FERME);
        assertThat(pigeon1.getPosition()).isEqualTo(ferme.POSITION_FERME);

    }

    @Test
    void ajouteDesVehiculesSansPasserParentreKO() {

        ferme.ajoute(vache1);

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(0);
    }

}