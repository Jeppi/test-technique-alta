package fr.altaprofits.exercice;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.vehicule.*;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HangarTest {

    Hangar hangar = new Hangar();

    Moto moto1 = new Moto();
    Voiture voiture1 = new Voiture();
    Avion avion1 = new Avion();
    Avion avion2 = new Avion();
    Helicoptere helico1 = new Helicoptere();
    JetSki jetSki1 = new JetSki();

    @Test
    void entreDansHangar() {
        // On fait entrer au moins un élément de chaque Véhicule
        hangar.entre(moto1);
        hangar.entre(voiture1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        assertThat(hangar.nombreDeVehiculesDansHangar()).isEqualTo(6);

        // On refait entrer des véhicules déjà présents
        hangar.entre(moto1);
        hangar.entre(voiture1);

        assertThat(hangar.nombreDeVehiculesDansHangar()).isEqualTo(6);

        // On ajoute un nouveau véhicule non présent
        hangar.entre(new Moto());

        assertThat(hangar.nombreDeVehiculesDansHangar()).isEqualTo(7);

    }

    @Test
    void nombreDeVehiculesDansAeroport() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.entre(moto1);
        hangar.entre(voiture1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        assertThat(hangar.nombreDeVehiculesDansAeroport()).isEqualTo(3);

    }

    @Test
    void nombreDeVehiculesDansGarage() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.entre(moto1);
        hangar.entre(voiture1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        assertThat(hangar.nombreDeVehiculesDansGarage()).isEqualTo(2);

    }

    @Test
    void nombreDeVehiculesDansPort() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.entre(moto1);
        hangar.entre(voiture1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        assertThat(hangar.nombreDeVehiculesDansPort()).isEqualTo(1);
    }

    @Test
    void nombreDeVehiculesDansHangar() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.entre(moto1);
        hangar.entre(voiture1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        assertThat(hangar.nombreDeVehiculesDansHangar()).isEqualTo(6);
    }

    @Test
    void idUniquePourChaqueVehicule() {

        Set<Vehicule> vehicules = Set.of(moto1, new Moto(), voiture1, new Voiture(), avion1, avion2,
                helico1, new Helicoptere(), jetSki1, new JetSki());

        // On a bien créé dix véhicules différents
        assertThat(vehicules.size()).isEqualTo(10);

        Set<String> references = vehicules.stream()
                .map(Vehicule::getReference)
                .collect(Collectors.toSet());

        // On a bien dix identifiants (références) distincts
        assertThat(references.size()).isEqualTo(10);

        // NB : le code ne garanti pas l'unicité si l'on crée deux entités du même type au même moment (à voir si c'est dans le scope)
    }

    @Test
    void vehiculesSeDeplacent() {

        moto1.seDeplace(5, 12);
        voiture1.seDeplace(17, 13);
        avion1.seDeplace(10, 30);
        avion1.seDeplace(30, 60);
        avion2.seDeplace(25, 55);
        helico1.seDeplace(23, 11);
        jetSki1.seDeplace(3, 9);

        assertThat(moto1.getPosition()).isEqualTo(new Point(5, 12));
        assertThat(voiture1.getPosition()).isEqualTo(new Point(17, 13));
        assertThat(avion1.getPosition()).isEqualTo(new Point(30, 60));
        assertThat(avion2.getPosition()).isEqualTo(new Point(25, 55));
        assertThat(helico1.getPosition()).isEqualTo(new Point(23, 11));
        assertThat(jetSki1.getPosition()).isEqualTo(new Point(3, 9));

    }

    @Test
    void affichageDansConsole() {

        // TODO à corriger : manuellement, l'affichage fonctionne, mais certaines valeurs sont peu explicites
    }

    @Test
    void affichageDansFichier() {

        // TODO à corriger : manuellement, même problème que l'affichage console, et en plus il n'affiche que le dernier élément de la liste.
    }

}