package fr.altaprofits.exercice;

import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.element.vehicule.*;

import java.io.File;
import java.io.FileNotFoundException;

import static fr.altaprofits.exercice.entreeSortie.Impression.imprimerTousLesVehiculesDuHangarDansConsole;
import static fr.altaprofits.exercice.entreeSortie.Impression.imprimerTousLesVehiculesDuHangarDansFichier;
import static fr.altaprofits.exercice.model.batiment.SectionHangar.*;

public class Application {
    public static void main(String[] args) {
        Hangar hangar = new Hangar();

        Moto moto1 = new Moto();
        Voiture voiture1 = new Voiture();
        Avion avion1 = new Avion();
        Avion       avion2 = new Avion();
        Helicoptere helico1 = new Helicoptere();
        JetSki jetSki1 = new JetSki();
        Bateau bateau1 = new Bateau();

        moto1.entre(hangar);
        voiture1.entre(hangar);
        avion1.entre(hangar);
        avion2.entre(hangar);
        helico1.entre(hangar);
        jetSki1.entre(hangar);
        bateau1.entre(hangar);

        imprimerTousLesVehiculesDuHangarDansConsole(hangar.getSections());

        try {
            imprimerTousLesVehiculesDuHangarDansFichier(new File("hangar.txt"), hangar.getSections());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Nombre de véhicules dans le hangar : " + hangar.nombreElementsDansBatiment());
        System.out.println("Nombre de véhicules dans l'aéroport : " + hangar.nombreElements(AEROPORT));
        System.out.println("Nombre de véhicules dans le garage : " + hangar.nombreElements(GARAGE));
        System.out.println("Nombre de véhicules dans le port : " + hangar.nombreElements(PORT));

        moto1.sort(hangar);
        voiture1.sort(hangar);
        avion1.sort(hangar);
        avion2.sort(hangar);
        helico1.sort(hangar);
        jetSki1.sort(hangar);
        bateau1.sort(hangar);

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
