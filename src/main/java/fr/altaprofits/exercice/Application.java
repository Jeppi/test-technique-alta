package fr.altaprofits.exercice;

import fr.altaprofits.exercice.model.Hangar;
import fr.altaprofits.exercice.model.vehicule.*;

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

        hangar.entre(moto1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);
        hangar.entre(voiture1);
        hangar.entre(bateau1);

        hangar.imprimerToutDansConsole();

        System.out.println("Nombre de véhicules dans le hangar : " + hangar.nombreDeVehiculesDansHangar());
        System.out.println("Nombre de véhicules dans l'aéroport : " + hangar.nombreDeVehiculesDansAeroport());
        System.out.println("Nombre de véhicules dans le garage : " + hangar.nombreDeVehiculesDansGarage());
        System.out.println("Nombre de véhicules dans le port : " + hangar.nombreDeVehiculesDansPort());

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
