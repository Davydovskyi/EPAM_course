package by.jonline.module_2.one_array;

/**
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько
 * в нем отрицательных, положительных и нулевых элементов.
 */

public class Task3 {

	public static void main(String[] args) {

		int n = 12;

		int countOfPositive = 0;
		int countOfNegative = 0;
		int countOfZero = 0;

		double[] array;
		array = createArray(n);

		for (double element : array) {

			if (element > 0) {
				countOfPositive++;
			} else if (element < 0) {
				countOfNegative++;
			} else {
				countOfZero++;
			}
		}

		System.out.printf("Positive numbers: %d%nNegative numbers: %d%nZero: %d", countOfPositive, countOfNegative,
				countOfZero);

	}

	public static double[] createArray(int length) {

		if (length < 0) {
			return new double[0];
		}

		double[] array = new double[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * 2 - 1;
		}

		return array;
	}

}
