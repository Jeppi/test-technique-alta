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

        assertThat(moto1.getReference()).isNotEqualTo(new Moto());
        assertThat(moto1.getReference()).isNotEqualTo(new Moto());

        assertThat(voiture1.getReference()).isNotEqualTo(new Voiture());
        assertThat(voiture1.getReference()).isNotEqualTo(moto1);

        assertThat(avion1.getReference()).isNotEqualTo(avion2);
        assertThat(avion1.getReference()).isNotEqualTo(new Avion());

        assertThat(helico1.getReference()).isNotEqualTo(new Helicoptere());

        assertThat(jetSki1.getReference()).isNotEqualTo(new JetSki());
        // TODO: On peut ajouter chaque id (référence) à un set, ce qui permettrait de vérifier qu'on n'a pas de doublons.
        // NB : le code ne garanti pas l'unicité si l'on créé deux entités du même type au même moment (à voir si c'est dans le scope)
    }

    @Test
    void vehiculesSeDeplacent() {
        // TODO: manuelement on peut constater que tous les véhicules peuvent se déplacer, je vais mutualisé le code
        // avant de créer le test pour éviter d'ajouter la même méthode sur chaque entité.
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