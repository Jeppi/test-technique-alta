package fr.altaprofits.exercice.commun;

public record Point(int x, int y) {

	public String toString () {
		return "(" + x + "," + y + ")";
	}
}
