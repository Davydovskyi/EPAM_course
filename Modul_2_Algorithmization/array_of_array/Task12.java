package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

public class Task12 {

	public static void main(String[] args) {

		int[][] matrix = { { 2, 6, 8, 1, 7 }, { 5, 7, 1, 0, 6 }, { 5, 3, 1, 7, 0, 4 } };

		sortRowAscending(matrix);
		printMatrix(matrix);

		sortRowDescending(matrix);
		printMatrix(matrix);
	}

	public static void sortRowAscending(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		boolean sorted;

		for (int i = 0; i < matrix.length; i++) {
			sorted = false;

			while (!sorted) {
				sorted = true;
				for (int j = 1; j < matrix[i].length; j++) {
					if (matrix[i][j] < matrix[i][j - 1]) {
						swap(matrix[i], j, j - 1);
						sorted = false;
					}
				}
			}
		}
	}

	public static void sortRowDescending(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		boolean sorted;

		for (int i = 0; i < matrix.length; i++) {
			sorted = false;

			while (!sorted) {
				sorted = true;
				for (int j = 1; j < matrix[i].length; j++) {
					if (matrix[i][j] > matrix[i][j - 1]) {
						swap(matrix[i], j, j - 1);
						sorted = false;
					}
				}
			}
		}
	}

	public static void swap(int[] array, int ind1, int ind2) {
		int temp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = temp;
	}

	public static boolean exists(int[][] matrix) {
		boolean exists = true;
		if (matrix == null || matrix.length == 0) {
			exists = false;
		}
		return exists;
	}

	public static void printMatrix(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println();
	}
}
