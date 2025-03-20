package fr.altaprofits.exercice;

import fr.altaprofits.exercice.model.environnement.Hangar;
import fr.altaprofits.exercice.model.element.Vehicule;

import java.io.File;
import java.io.FileNotFoundException;

import static fr.altaprofits.exercice.entreeSortie.Impression.*;
import static fr.altaprofits.exercice.model.environnement.SectionHangar.*;
import static fr.altaprofits.exercice.model.element.TypeVehicule.*;

public class Application {
    public static void main(String[] args) {
        Hangar hangar = new Hangar();

        Vehicule moto1 = new Vehicule(MOTO);
        Vehicule voiture1 = new Vehicule(VOITURE);
        Vehicule avion1 = new Vehicule(AVION);
        Vehicule avion2 = new Vehicule(AVION);
        Vehicule helico1 = new Vehicule(HELICOPTERE);
        Vehicule jetSki1 = new Vehicule(JETSKI);
        Vehicule bateau1 = new Vehicule(BATEAU);

        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);

        imprimerTousLesElementsDuBatimentDansConsole(hangar.getSections());

        try {
            imprimerTousLesElementsDuBatimentDansFichier(new File("hangar.txt"), hangar.getSections());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Nombre de véhicules dans le hangar : " + hangar.nombreElementsDansBatiment());
        System.out.println("Nombre de véhicules dans l'aéroport : " + hangar.nombreElements(AEROPORT));
        System.out.println("Nombre de véhicules dans le garage : " + hangar.nombreElements(GARAGE));
        System.out.println("Nombre de véhicules dans le port : " + hangar.nombreElements(PORT));

        hangar.faitEntrer(moto1);
        hangar.faitEntrer(voiture1);
        hangar.faitEntrer(avion1);
        hangar.faitEntrer(avion2);
        hangar.faitEntrer(helico1);
        hangar.faitEntrer(jetSki1);
        hangar.faitEntrer(bateau1);

        System.out.println("Nombre de véhicules dans le hangar : " + hangar.nombreElementsDansBatiment());
        System.out.println("Nombre de véhicules dans l'aéroport : " + hangar.nombreElements(AEROPORT));
        System.out.println("Nombre de véhicules dans le garage : " + hangar.nombreElements(GARAGE));
        System.out.println("Nombre de véhicules dans le port : " + hangar.nombreElements(PORT));

        moto1.seDeplace(5, 12);
        voiture1.seDeplace(17, 13);
        avion1.seDeplace(10, 30);
        avion1.seDeplace(30, 60);
        avion2.seDeplace(25, 55);
        helico1.seDeplace(23, 11);
        jetSki1.seDeplace(3, 9);
        bateau1.seDeplace(31, 33);
    }
}
