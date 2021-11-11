package by.jonline.module_1.cycle;

/**
 * Вычислить значения функции на отрезке [а, b] c шагом h: y = x, x > 2 y = - x,
 * x <= 2.
 */

public class Task2 {

	public static void main(String[] args) {

		double a = -5;
		double b = 5;

		double h = 0.5;

		double y;

		for (double x = a; x <= b; x += h) {

			if (x == 0) {
				y = x;

				System.out.println("y = " + y);

				continue;
			}

			if (x <= 2) {
				y = -x;

				System.out.println("y = " + y);

			} else {
				y = x;

				System.out.println("y = " + y);

			}
		}

	}

}
