package by.jonline.branching;

/**
 * Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
 * Определить, пройдет ли кирпич через отверстие.
 */

public class Task4 {

	public static void main(String[] args) {

		int holeA = 5;
		int holeB = 10;

		int x = 5;
		int y = 11;
		int z = 6;

		if (compareSize(holeA, holeB, x, y) || compareSize(holeA, holeB, x, z) || compareSize(holeA, holeB, y, z)) {

			System.out.println("Кирпич пройдет через отверстие.");

		} else {

			System.out.println("Кирпич не пройдет через отверстие.");
		}

	}

	public static boolean compareSize(int holeA, int holeB, int brickSize1, int brickSize2) {

		return holeA >= brickSize1 && holeB >= brickSize2 || holeA >= brickSize2 && holeB >= brickSize1;

	}

}
