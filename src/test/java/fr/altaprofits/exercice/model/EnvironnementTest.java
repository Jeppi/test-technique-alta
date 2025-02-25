package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.model.element.animal.Canard;
import fr.altaprofits.exercice.model.element.animal.Pigeon;
import fr.altaprofits.exercice.model.element.animal.Vache;
import fr.altaprofits.exercice.model.batiment.Ferme;
import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.batiment.SectionHangar;
import fr.altaprofits.exercice.model.element.vehicule.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EnvironnementTest {

    Ferme ferme = new Ferme();

    Vache vache1 = new Vache();
    Pigeon pigeon1 = new Pigeon();
    Canard canard1 = new Canard();
    Vache vache2 = new Vache();
    Pigeon pigeon2 = new Pigeon();
    Canard canard2 = new Canard();
    Vache vache3 = new Vache();
    Canard canard3 = new Canard();

    Hangar      hangar = new Hangar();

    Moto moto1 = new Moto();
    Voiture voiture1 = new Voiture();
    Avion       avion1 = new Avion();
    Avion       avion2 = new Avion();
    Helicoptere helico1 = new Helicoptere();
    JetSki jetSki1 = new JetSki();
    Bateau bateau1 = new Bateau();
    Hydravion hydravion1 = new Hydravion();
    Hydravion   hydravionAeroport = new Hydravion().setSection(SectionHangar.AEROPORT);

    Environnement environnement = new Environnement(ferme, hangar);

    @Test
    void nombreElementsParTypeDeDeplacement() {

        vache1.entre(ferme);
        pigeon1.entre(ferme);
        canard1.entre(ferme);
        vache2.entre(ferme);
        pigeon2.entre(ferme);
        canard2.entre(ferme);
        canard3.entre(ferme);
        vache3.entre(ferme);
        new Vache().entre(ferme);

        moto1.entre(hangar);
        voiture1.entre(hangar);
        avion1.entre(hangar);
        avion2.entre(hangar);
        helico1.entre(hangar);
        jetSki1.entre(hangar);
        bateau1.entre(hangar);
        hydravion1.entre(hangar);
        hydravionAeroport.entre(hangar);

        // Les canards sont volants et navigants.
        assertThat(environnement.nombreElementsVolants()).isEqualTo(10);
        assertThat(environnement.nombreElementsRoulants()).isEqualTo(6);
        assertThat(environnement.nombreElementsNavigants()).isEqualTo(5);
    }
}