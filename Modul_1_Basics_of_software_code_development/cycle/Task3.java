package by.jonline.module_1.cycle;

/**
 * Найти сумму квадратов первых ста чисел.
 */

public class Task3 {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 0; i <= 100; i++) {
			sum += Math.pow(i, 2);
		}

		System.out.println("result = " + sum);

	}

}
