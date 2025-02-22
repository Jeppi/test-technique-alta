package fr.altaprofits.exercice.model;

import fr.altaprofits.exercice.model.vehicule.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;

public class Hangar {
	// Contient les avions
	private HashSet<Avion> aList = new HashSet<>();

	// Contient les hélicopteres
	private HashSet<Helicoptere> hList = new HashSet<>();

	// Contient les bateaux
	private HashSet<Bateau> bList = new HashSet<>();

	// Contient les jetskis
	private HashSet<JetSki> jList = new HashSet<>();

	// Contient les motos
	private HashSet<Moto> mList = new HashSet<>();

	// Contient les voitures
	private HashSet<Voiture> vList = new HashSet<>();

	public void entre(Avion a) {
		aList.add(a);
	}

	public void entre(Helicoptere h) {
		hList.add(h);
	}

	public void entre(Bateau b) {
		bList.add(b);
	}

	public void entre(JetSki j) {
		jList.add(j);
	}

	public void entre(Moto m) {
		mList.add(m);
	}

	public void entre(Voiture v) {
		vList.add(v);
	}

	public int nombreDeVehiculesDansAeroport() {
		return aList.size() + hList.size();
	}

	public int nombreDeVehiculesDansGarage() {
		return mList.size() + vList.size();
	}

	public int nombreDeVehiculesDansPort() {
		return jList.size() + bList.size();
	}

	public int nombreDeVehiculesDansHangar() {
		return nombreDeVehiculesDansPort() + nombreDeVehiculesDansAeroport() + nombreDeVehiculesDansGarage();
	}

	private void imprimerDansConsole(Avion a) {
		System.out.println("Vehicule de type "  + a.getClass().getSimpleName());
		System.out.println(a);
	}


	private void imprimerDansConsole(Helicoptere h) {
		System.out.println("Vehicule de type "  + h.getClass().getSimpleName());
		System.out.println(h);
	}

	private void imprimerDansConsole(Bateau b) {
		System.out.println("Vehicule de type "  + b.getClass().getSimpleName());
		System.out.println(b);
	}

	private void imprimerDansConsole(JetSki j) {
		System.out.println("Vehicule de type "  + j.getClass().getSimpleName());
		System.out.println(j);
	}

	private void imprimerDansConsole(Moto m) {
		System.out.println("Vehicule de type "  + m.getClass().getSimpleName());
		System.out.println(m);
	}

	private void imprimerDansConsole(Voiture v) {
		System.out.println("Vehicule de type "  + v.getClass().getSimpleName());
		System.out.println(v);
	}

	private void imprimerDansFichier(Avion a, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("Vehicule de type "  + a.getClass().getSimpleName());
		printStream.println(a);
	}

	private void imprimerDansFichier(Helicoptere h, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("Vehicule de type "  + h.getClass().getSimpleName());
		printStream.println(h);
	}

	private void imprimerDansFichier(Bateau b, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("Vehicule de type "  + b.getClass().getSimpleName());
		printStream.println(b);
	}

	private void imprimerDansFichier(JetSki j, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("Vehicule de type "  + j.getClass().getSimpleName());
		printStream.println(j);
	}

	private void imprimerDansFichier(Moto m, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("Vehicule de type "  + m.getClass().getSimpleName());
		printStream.println(m);
	}

	private void imprimerDansFichier(Voiture v, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("Vehicule de type "  + v.getClass().getSimpleName());
		printStream.println(v);
	}

	public void imprimerToutDansConsole() {
		for (Avion a : aList)
			imprimerDansConsole(a);

		for (Helicoptere h : hList)
			imprimerDansConsole(h);

		for (Bateau b : bList)
			imprimerDansConsole(b);

		for (JetSki j : jList)
			imprimerDansConsole(j);

		for (Moto m : mList)
			imprimerDansConsole(m);

		for (Voiture v : vList)
			imprimerDansConsole(v);
	}

	public void imprimerToutDansFichier(File f) throws FileNotFoundException {
		for (Avion a : aList)
			imprimerDansFichier(a, f);

		for (Helicoptere h : hList)
			imprimerDansFichier(h, f);

		for (Bateau b : bList)
			imprimerDansFichier(b, f);

		for (JetSki j : jList)
			imprimerDansFichier(j, f);

		for (Moto m : mList)
			imprimerDansFichier(m, f);

		for (Voiture v : vList)
			imprimerDansFichier(v, f);
	}
}
