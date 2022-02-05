package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */

public class Task15 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int maxElement;
		maxElement = findMax(matrix);

		replaceElement(matrix, maxElement);

		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}
	}

	public static int findMax(int[][] matrix) {

		int max = Integer.MIN_VALUE;

		if (matrix == null || matrix.length == 0) {
			return max;
		}

		for (int[] array : matrix) {
			for (int element : array) {
				if (element > max) {
					max = element;
				}
			}
		}

		return max;
	}

	public static void replaceElement(int[][] matrix, int value) {

		if (matrix == null || matrix.length == 0) {
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] % 2 != 0) {
					matrix[i][j] = value;
				}
			}
		}
	}
}
