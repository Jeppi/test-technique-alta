package fr.altaprofits.exercice;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.environnement.Ferme;
import fr.altaprofits.exercice.model.environnement.SectionFerme;
import fr.altaprofits.exercice.model.element.Animal;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static fr.altaprofits.exercice.model.element.TypeAnimal.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FermeTest {

    Ferme ferme = new Ferme();

    Animal vache1 = new Animal(VACHE);
    Animal pigeon1 = new Animal(PIGEON);
    Animal canard1 = new Animal(CANARD);
    Animal vache2 = new Animal(VACHE);
    Animal pigeon2 = new Animal(PIGEON);
    Animal canard2 = new Animal(CANARD);
    Animal vache3 = new Animal(VACHE);
    Animal pigeon3 = new Animal(PIGEON);
    Animal canard3 = new Animal(CANARD);

    @Test
    void entre() {

        ferme.faitEntrer(vache1);
        ferme.faitEntrer(pigeon1);
        ferme.faitEntrer(canard1);
        ferme.faitEntrer(vache2);
        ferme.faitEntrer(pigeon2);
        ferme.faitEntrer(canard2);

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(6);

        // On refait entrer
        ferme.faitEntrer(pigeon1);
        ferme.faitEntrer(vache2);

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(6);

        // On ajoute un nouveau
        ferme.faitEntrer(new Animal(CANARD));

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
        ferme.faitEntrer(vache1);
        ferme.faitEntrer(pigeon1);
        ferme.faitEntrer(canard1);
        ferme.faitEntrer(vache2);
        ferme.faitEntrer(pigeon2);
        ferme.faitEntrer(canard2);

        // Aucun ne peut entrer
        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(0);

    }

    @Test
    void nombreAnimauxParSection() {

        ferme.faitEntrer(vache1);
        ferme.faitEntrer(pigeon1);
        ferme.faitEntrer(canard1);
        ferme.faitEntrer(vache2);
        ferme.faitEntrer(pigeon2);
        ferme.faitEntrer(canard2);
        ferme.faitEntrer(canard3);
        ferme.faitEntrer(vache3);
        ferme.faitEntrer(new Animal(VACHE));

        assertThat(ferme.nombreElementsDansBatiment()).isEqualTo(9);

        assertThat(ferme.nombreElements(SectionFerme.PIGEONNIER)).isEqualTo(2);
        assertThat(ferme.nombreElements(SectionFerme.ETABLE)).isEqualTo(4);
        assertThat(ferme.nombreElements(SectionFerme.ETANG)).isEqualTo(3);

    }

    @Test
    void idUniquePourChaqueAnimal() {

        Set<Animal> animaux = Set.of(vache1, vache2, pigeon2, pigeon1, pigeon3, canard1,
                canard2, canard3, new Animal(VACHE));

        Set<String> references = animaux.stream()
                .map(Animal::getReference)
                .collect(Collectors.toSet());

        // On a bien le même nombre d'id distinct que de véhicules
        assertThat(references.size()).isEqualTo(animaux.size());

        // NB : le code ne garanti pas l'unicité si l'on crée deux entités du même type au même moment (à voir si c'est dans le scope)
    }

    @Test
    void elementsSeDeplacent() {

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
    void elementsSeDeplacentKO() {

        // On fait entrer les animaux dans la ferme, ils ne peuvent plus se déplacer avant d'en sortir
        ferme.faitEntrer(vache1);
        ferme.faitEntrer(vache2);
        ferme.faitEntrer(canard1);
        ferme.faitEntrer(canard2);
        ferme.faitEntrer(pigeon1);

        vache1.seDeplace(5, 12);
        vache2.seDeplace(17, 13);
        canard1.seDeplace(10, 30);
        canard1.seDeplace(30, 60);
        canard2.seDeplace(25, 55);
        pigeon1.seDeplace(23, 11);

        assertThat(vache1.getPosition()).isEqualTo(ferme.POSITION);
        assertThat(vache2.getPosition()).isEqualTo(ferme.POSITION);
        assertThat(canard1.getPosition()).isEqualTo(ferme.POSITION);
        assertThat(canard2.getPosition()).isEqualTo(ferme.POSITION);
        assertThat(pigeon1.getPosition()).isEqualTo(ferme.POSITION);

    }

    // Ajout fonctionnel de la méthode qui donne le nombre d'éléments par type de déplacement.
    @Test
    void nombreElementsParTypeDeDeplacement() {

        ferme.faitEntrer(vache1);
        ferme.faitEntrer(pigeon1);
        ferme.faitEntrer(canard1);
        ferme.faitEntrer(vache2);
        ferme.faitEntrer(pigeon2);
        ferme.faitEntrer(canard2);
        ferme.faitEntrer(canard3);
        ferme.faitEntrer(vache3);
        ferme.faitEntrer(new Animal(VACHE));

        // Canard est volant et navigant.
        assertThat(ferme.nombreElementsVolants()).isEqualTo(5);
        assertThat(ferme.nombreElementsRoulants()).isEqualTo(4);
        assertThat(ferme.nombreElementsNavigants()).isEqualTo(3);
    }

}