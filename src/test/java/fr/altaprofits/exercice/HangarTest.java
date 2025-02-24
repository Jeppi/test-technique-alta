package fr.altaprofits.exercice;

import fr.altaprofits.exercice.commun.Point;
import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.batiment.SectionHangar;
import fr.altaprofits.exercice.model.vehicule.*;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static fr.altaprofits.exercice.model.batiment.SectionHangar.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HangarTest {

    Hangar hangar = new Hangar();

    Moto        moto1 = new Moto();
    Voiture     voiture1 = new Voiture();
    Avion       avion1 = new Avion();
    Avion       avion2 = new Avion();
    Helicoptere helico1 = new Helicoptere();
    JetSki      jetSki1 = new JetSki();
    Bateau      bateau1 = new Bateau();
    Hydravion   hydravion1 = new Hydravion();
    Hydravion   hydravionAeroport = new Hydravion().setSection(SectionHangar.AEROPORT);


    @Test
    void entreDansHangar() {
        // On fait entrer au moins un élément de chaque Véhicule
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(9);

        // On refait entrer des véhicules déjà présents
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(9);

        // On ajoute un nouveau véhicule non présent
        new Moto().entreDansHangar(hangar);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(10);

    }

    @Test
    void entreDansHangarKO() {
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
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);


        // Aucun ne peut entrer
        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(0);

    }

    @Test
    void nombreDeVehiculesDansAeroport() {

        // On fait entrer au moins un élément de chaque Véhicule
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);

        assertThat(hangar.nombreDeVehiculesDansAeroport()).isEqualTo(4);

    }

    @Test
    void nombreDeVehiculesDansGarage() {

        // On fait entrer au moins un élément de chaque Véhicule
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);


        assertThat(hangar.nombreDeVehiculesDansGarage()).isEqualTo(2);

    }

    @Test
    void nombreDeVehiculesDansPort() {

        // On fait entrer au moins un élément de chaque Véhicule
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);

        assertThat(hangar.nombreDeVehiculesDansPort()).isEqualTo(3);
    }

    @Test
    void nombreDeVehiculesDansHangar() {

        // On fait entrer au moins un élément de chaque Véhicule
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(9);
    }

    @Test
    void idUniquePourChaqueVehicule() {

        Set<Vehicule> vehicules = Set.of(moto1, new Moto(), voiture1, new Voiture(), avion1, avion2,
                helico1, new Helicoptere(), jetSki1, new JetSki(), bateau1, new Bateau(),
                hydravion1, hydravionAeroport);

        Set<String> references = vehicules.stream()
                .map(Vehicule::getReference)
                .collect(Collectors.toSet());

        // On a bien le même nombre d'id distinct que de véhicules
        assertThat(references.size()).isEqualTo(vehicules.size());

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
        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);

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

        assertThat(moto1.getPosition()).isEqualTo(hangar.POSITION_HANGAR);
        assertThat(voiture1.getPosition()).isEqualTo(hangar.POSITION_HANGAR);
        assertThat(avion1.getPosition()).isEqualTo(hangar.POSITION_HANGAR);
        assertThat(avion2.getPosition()).isEqualTo(hangar.POSITION_HANGAR);
        assertThat(helico1.getPosition()).isEqualTo(hangar.POSITION_HANGAR);
        assertThat(jetSki1.getPosition()).isEqualTo(hangar.POSITION_HANGAR);
        assertThat(bateau1.getPosition()).isEqualTo(hangar.POSITION_HANGAR);

    }

    @Test
    void ajouteDesVehiculesSansPasserParEntreDansHangarKO() {

        hangar.ajoute(moto1);

        assertThat(hangar.nombreElementsDansBatiment()).isEqualTo(0);
    }

    @Test
    void changementDeSectionHydravion() {
        assertThat(hydravion1.getSection()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSection()).isEqualTo(AEROPORT);

        // On change leur section :
        hydravion1.setSection(AEROPORT);
        hydravionAeroport.setSection(PORT);

        assertThat(hydravion1.getSection()).isEqualTo(AEROPORT);
        assertThat(hydravionAeroport.getSection()).isEqualTo(PORT);
    }

    @Test
    void changementDeSectionHydravionKO() {
        assertThat(hydravion1.getSection()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSection()).isEqualTo(AEROPORT);

        // On change leurs sections avec des sections non autorisées :
        hydravion1.setSection(GARAGE);
        hydravionAeroport.setSection(GARAGE);

        // Ils restent dans les mêmes sections
        assertThat(hydravion1.getSection()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSection()).isEqualTo(AEROPORT);

        // On les stationne puis on change leurs sections :
        hydravion1.entreDansHangar(hangar);
        hydravionAeroport.entreDansHangar(hangar);
        hydravion1.setSection(AEROPORT);
        hydravionAeroport.setSection(PORT);

        // Ils restent dans les mêmes sections
        assertThat(hydravion1.getSection()).isEqualTo(PORT);
        assertThat(hydravionAeroport.getSection()).isEqualTo(AEROPORT);

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