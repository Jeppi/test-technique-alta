package fr.altaprofits.exercice;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.environnement.Hangar;
import fr.altaprofits.exercice.model.element.Vehicule;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static fr.altaprofits.exercice.model.environnement.SectionHangar.*;
import static fr.altaprofits.exercice.model.element.TypeVehicule.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HangarTest {

    Hangar          hangar = new Hangar();

    Vehicule            moto1 = new Vehicule(MOTO);
    Vehicule         voiture1 = new Vehicule(VOITURE);
    Vehicule           avion1 = new Vehicule(AVION);
    Vehicule           avion2 = new Vehicule(AVION);
    Vehicule     helico1 = new Vehicule(HELICOPTERE);
    Vehicule          jetSki1 = new Vehicule(JETSKI);
    Vehicule          bateau1 = new Vehicule(BATEAU);
    Vehicule       hydravion1 = new Vehicule(HYDRAVION);
    Vehicule       hydravionAeroport = new Vehicule(HYDRAVION).setSectionActive(AEROPORT);


    @Test
    void entre() {
        // On fait entrer au moins un élément de chaque Véhicule
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(9);

        // On refait entrer des véhicules déjà présents
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(9);

        // On ajoute un nouveau véhicule non présent
        hangar.faitEntrer(new Vehicule(MOTO));

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(10);

    }

    @Test
    void entreKO() {
        // On déplace les véhicules, ils ne sont plus à la localisation du hangar (0,0)
        moto1.seDeplace(5, 12);
        voiture1.seDeplace(17, 13);
        avion1.seDeplace(10, 30);
        avion2.seDeplace(25, 55);
        helico1.seDeplace(23, 11);
        jetSki1.seDeplace(3, 9);
        bateau1.seDeplace(31, 33);
        hydravion1.seDeplace(39, 43);
        hydravionAeroport.seDeplace(41, 44);

        // On essaye de faire entrer les véhicules dans le hangar
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);


        // Aucun ne peut entrer
        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(0);

    }

    @Test
    void nombreDeVehiculesDansAeroport() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);

        assertThat(hangar.nombreElements(AEROPORT)).isEqualTo(4);

    }

    @Test
    void nombreDeVehiculesDansGarage() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);


        assertThat(hangar.nombreElements(GARAGE)).isEqualTo(2);

    }

    @Test
    void nombreDeVehiculesDansPort() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        //hangar.faitEntrer(hydravionAeroport);

        assertThat(hangar.nombreElements(PORT)).isEqualTo(3);
    }

    @Test
    void nombreDeVehiculesDansHangar() {

        // On fait entrer au moins un élément de chaque Véhicule
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(9);
    }

    @Test
    void idUniquePourChaqueVehicule() {

        Set<Vehicule> vehicules = Set.of(moto1, new Vehicule(MOTO), voiture1, new Vehicule(VOITURE), avion1, avion2,
                helico1, new Vehicule(HELICOPTERE), jetSki1, new Vehicule(JETSKI), bateau1, new Vehicule(BATEAU),
                hydravion1, hydravionAeroport);

        Set<String> references = vehicules.stream()
                .map(Vehicule::getReference)
                .collect(Collectors.toSet());

        // On a bien le même nombre d'id distinct que de véhicules
        assertThat(references.size()).isEqualTo(vehicules.size());
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
        bateau1.seDeplace(31, 33);
        hydravion1.seDeplace(39, 43);
        hydravionAeroport.seDeplace(41, 44);

        assertThat(moto1.getPosition()).isEqualTo(new Point(5, 12));
        assertThat(voiture1.getPosition()).isEqualTo(new Point(17, 13));
        assertThat(avion1.getPosition()).isEqualTo(new Point(30, 60));
        assertThat(avion2.getPosition()).isEqualTo(new Point(25, 55));
        assertThat(helico1.getPosition()).isEqualTo(new Point(23, 11));
        assertThat(jetSki1.getPosition()).isEqualTo(new Point(3, 9));
        assertThat(bateau1.getPosition()).isEqualTo(new Point(31, 33));
        assertThat(hydravion1.getPosition()).isEqualTo(new Point(39, 43));
        assertThat(hydravionAeroport.getPosition()).isEqualTo(new Point(41, 44));

    }

    @Test
    void vehiculesSeDeplacentKO() {

        // On fait entrer les véhicules dans le hangar, ils ne peuvent plus se déplacer avant d'en sortir
        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);

        moto1.seDeplace(5, 12);
        voiture1.seDeplace(17, 13);
        avion1.seDeplace(10, 30);
        avion1.seDeplace(30, 60);
        avion2.seDeplace(25, 55);
        helico1.seDeplace(23, 11);
        jetSki1.seDeplace(3, 9);
        bateau1.seDeplace(31, 33);
        hydravion1.seDeplace(39, 43);
        hydravionAeroport.seDeplace(41, 44);

        assertThat(moto1.getPosition()).isEqualTo(hangar.POSITION);
        assertThat(voiture1.getPosition()).isEqualTo(hangar.POSITION);
        assertThat(avion1.getPosition()).isEqualTo(hangar.POSITION);
        assertThat(avion2.getPosition()).isEqualTo(hangar.POSITION);
        assertThat(helico1.getPosition()).isEqualTo(hangar.POSITION);
        assertThat(jetSki1.getPosition()).isEqualTo(hangar.POSITION);
        assertThat(bateau1.getPosition()).isEqualTo(hangar.POSITION);

    }

    @Test
    void changementDeSectionHydravion() {
        assertThat(hydravion1.getSectionActive()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(AEROPORT);

        // On change leur section :
        hydravion1.setSectionActive(AEROPORT);
        hydravionAeroport.setSectionActive(PORT);

        assertThat(hydravion1.getSectionActive()).isEqualTo(AEROPORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(PORT);

    }

    @Test
    void changementDeSectionAvecSortie() {
        assertThat(hydravion1.getSectionActive()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(AEROPORT);

        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);

        // On ne peut changer leur section tant qu'ils sont à l'intérieur :
        hydravion1.setSectionActive(AEROPORT);
        hydravionAeroport.setSectionActive(PORT);

        assertThat(hydravion1.getSectionActive()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(AEROPORT);

        // On doit les fait sortir pour changer leur section :
        hangar.faitSortir(hydravion1);
        hangar.faitSortir(hydravionAeroport);

        hydravion1.setSectionActive(AEROPORT);
        hydravionAeroport.setSectionActive(PORT);

        assertThat(hydravion1.getSectionActive()).isEqualTo(AEROPORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(PORT);

    }

    @Test
    void changementDeSectionHydravionKO() {
        assertThat(hydravion1.getSectionActive()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(AEROPORT);

        // On change leurs sections avec des sections non autorisées :
        hydravion1.setSectionActive(GARAGE);
        hydravionAeroport.setSectionActive(GARAGE);

        // Ils restent dans les mêmes sections
        assertThat(hydravion1.getSectionActive()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(AEROPORT);

        // On les stationne puis on change leurs sections :
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);
        hydravion1.setSectionActive(AEROPORT);
        hydravionAeroport.setSectionActive(PORT);

        // Ils restent dans les mêmes sections
        assertThat(hydravion1.getSectionActive()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSectionActive()).isEqualTo(AEROPORT);

    }

    // Ajout fonctionnel de la méthode qui donne le nombre d'éléments par type de déplacement.
    @Test
    void nombreElementsParTypeDeDeplacement() {

        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);
        hangar.faitEntrer(hydravion1);
        hangar.faitEntrer(hydravionAeroport);

        assertThat(hangar.nombreElementsVolants()).isEqualTo(5);
        assertThat(hangar.nombreElementsRoulants()).isEqualTo(2);
        assertThat(hangar.nombreElementsNavigants()).isEqualTo(2);
    }


}