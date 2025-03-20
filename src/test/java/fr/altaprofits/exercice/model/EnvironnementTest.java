package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.model.environnement.Environnement;
import fr.altaprofits.exercice.model.environnement.Ferme;
import fr.altaprofits.exercice.model.environnement.Hangar;
import fr.altaprofits.exercice.model.element.Animal;
import fr.altaprofits.exercice.model.element.Vehicule;
import org.junit.jupiter.api.Test;

import static fr.altaprofits.exercice.model.environnement.SectionHangar.AEROPORT;
import static fr.altaprofits.exercice.model.element.TypeAnimal.*;
import static fr.altaprofits.exercice.model.element.TypeVehicule.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EnvironnementTest {

    Ferme ferme = new Ferme();

    Animal vache1 = new Animal(VACHE);
    Animal pigeon1 = new Animal(PIGEON);
    Animal canard1 = new Animal(CANARD);
    Animal vache2 = new Animal(VACHE);
    Animal pigeon2 = new Animal(PIGEON);
    Animal canard2 = new Animal(CANARD);
    Animal vache3 = new Animal(VACHE);
    Animal canard3 = new Animal(CANARD);

    Hangar      hangar = new Hangar();

    Vehicule moto1 = new Vehicule(MOTO);
    Vehicule voiture1 = new Vehicule(VOITURE);
    Vehicule avion1 = new Vehicule(AVION);
    Vehicule avion2 = new Vehicule(AVION);
    Vehicule helico1 = new Vehicule(HELICOPTERE);
    Vehicule jetSki1 = new Vehicule(JETSKI);
    Vehicule bateau1 = new Vehicule(BATEAU);
    Vehicule hydravion1 = new Vehicule(HYDRAVION);
    Vehicule hydravionAeroport = new Vehicule(HYDRAVION).setSectionActive(AEROPORT);

    Environnement environnement = new Environnement(ferme, hangar);

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

        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);

        // Les canards sont volants et navigants.
        assertThat(environnement.nombreElementsVolants()).isEqualTo(10);
        assertThat(environnement.nombreElementsRoulants()).isEqualTo(6);
        assertThat(environnement.nombreElementsNavigants()).isEqualTo(5);
    }
}