package by.jonline.module_2.decomposition;

/**
 * Вычислить площадь правильного шестиугольника со стороной а, используя метод
 * вычисления площади треугольника.
 */

public class Task3 {

	public static void main(String[] args) {

		double a = 5;

		if (a <= 0) {
			return;
		}

		System.out.println(getHexagonSquare(a));
	}

	public static double getHexagonSquare(double a) {
		return 6 * getTriangleSquare(a);
	}

	public static double getTriangleSquare(double a) {
		return Math.pow(a, 2) * Math.sqrt(3) / 4;
	}
}