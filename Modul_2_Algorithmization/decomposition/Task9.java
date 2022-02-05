package by.jonline.module_2.decomposition;

/**
 * Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы)
 * вычисления его площади, если угол между сторонами длиной X и Y — прямой.
 */

public class Task9 {

	public static void main(String[] args) {

		int x = 3;
		int y = 4;
		int z = 3;
		int t = 6;

		if (x < 1 || y < 1 || z < 1 || t < 1 || !checkIfExists(x, y, z, t)) {
			return;
		}

		double diagonal;
		diagonal = getDiagonal(x, y);

		double squareXYZT;
		squareXYZT = getSquareHeron(x, y, diagonal) + getSquareHeron(t, z, diagonal);

		System.out.println(squareXYZT);
	}

	public static double getDiagonal(double a, double b) {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	public static double getSquareHeron(double a, double b, double c) {

		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	public static boolean checkIfExists(double a, double b, double c, double d) {

		return a + b + c > d && a + b + d > c && a + c + d > b && b + c + d > a;
	}
}