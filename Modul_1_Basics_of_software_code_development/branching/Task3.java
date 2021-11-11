package by.jonline.branching;

/**
 * Даны три точки А(х1, у1), В(х2, у2) и С(х3, у3). Определить, будут ли они
 * расположены на одной прямой.
 */

public class Task3 {

	public static void main(String[] args) {

		int xA = -2;
		int yA = -2;

		int xB = 1;
		int yB = 1;

		int xC = 2;
		int yC = 2;

		if ((xA - xB) * (yC - yB) == (xC - xB) * (yA - yB)) {

			System.out.println("Точки находятся на одной прямой.");

		} else {

			System.out.println("Точки не находятся на одной прямой.");
		}

	}

}
