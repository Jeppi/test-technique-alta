package fr.altaprofits.exercice;

import fr.altaprofits.exercice.vehicule.*;
import org.junit.jupiter.api.Test;

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
    void testVehiculesEntreDansHangar() {
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
    void nombreDeVehiculeDansPort() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.entre(moto1);
        hangar.entre(voiture1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        assertThat(hangar.nombreDeVehiculesDansPort()).isEqualTo(2);
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

}