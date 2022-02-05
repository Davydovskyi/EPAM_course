package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом
 * столбце. Определить, какой столбец содержит максимальную сумму.
 */

public class Task9 {

	public static void main(String[] args) {

		double[][] matrix = { { 1, 2, 4 }, { 4, 5, 6, 13 }, { 7, 8, 9 } };

		double[] sumInColumns;
		sumInColumns = sumUpColumns(matrix);

		int indexOfMaxSum;
		indexOfMaxSum = findIndexOfMaxValue(sumInColumns);

		System.out.println(Arrays.toString(sumInColumns));

		System.out.println(indexOfMaxSum);
	}

	public static double[] sumUpColumns(double[][] matrix) {

		if (matrix == null) {
			return new double[0];
		}

		int countOfColumns = 0;

		for (int i = 0; i < matrix.length; i++) {

			if (countOfColumns < matrix[i].length) {
				countOfColumns = matrix[i].length;
			}
		}

		double[] sumInColumns = new double[countOfColumns];

		for (int i = 0; i < countOfColumns; i++) {

			for (int j = 0; j < matrix.length; j++) {

				if (matrix[j].length - 1 < i) {
					continue;
				}

				if (matrix[j][i] > 0) {
					sumInColumns[i] += matrix[j][i];
				}
			}
		}

		return sumInColumns;
	}

	public static int findIndexOfMaxValue(double[] array) {

		if (array.length == 0) {
			return 0;
		}

		int index = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[index] < array[i]) {
				index = i;
			}
		}

		return index;
	}
}
