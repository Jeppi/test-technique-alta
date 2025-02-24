package fr.altaprofits.exercice;

import fr.altaprofits.exercice.model.batiment.Hangar;
import fr.altaprofits.exercice.model.batiment.SectionHangar;
import fr.altaprofits.exercice.model.vehicule.*;

import java.io.File;
import java.io.FileNotFoundException;

import static fr.altaprofits.exercice.entreeSortie.Impression.imprimerTousLesVehiculesDuHangarDansConsole;
import static fr.altaprofits.exercice.entreeSortie.Impression.imprimerTousLesVehiculesDuHangarDansFichier;
import static fr.altaprofits.exercice.model.batiment.SectionHangar.*;

public class Application {
    public static void main(String[] args) {
        Hangar hangar = new Hangar();

        Moto        moto1 = new Moto();
        Voiture     voiture1 = new Voiture();
        Avion       avion1 = new Avion();
        Avion       avion2 = new Avion();
        Helicoptere helico1 = new Helicoptere();
        JetSki      jetSki1 = new JetSki();
        Bateau      bateau1 = new Bateau();

        moto1.entreDansHangar(hangar);
        voiture1.entreDansHangar(hangar);
        avion1.entreDansHangar(hangar);
        avion2.entreDansHangar(hangar);
        helico1.entreDansHangar(hangar);
        jetSki1.entreDansHangar(hangar);
        bateau1.entreDansHangar(hangar);

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

        moto1.sortDuHangar(hangar);
        voiture1.sortDuHangar(hangar);
        avion1.sortDuHangar(hangar);
        avion2.sortDuHangar(hangar);
        helico1.sortDuHangar(hangar);
        jetSki1.sortDuHangar(hangar);
        bateau1.sortDuHangar(hangar);

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
