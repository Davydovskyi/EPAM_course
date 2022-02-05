package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 */

public class Task13 {

	public static void main(String[] args) {

		int[][] matrix = { { 20, 9, 7, 12 }, { 8, 4, 2 }, { -10, -4, 5 }, { 3, 5, 1, 6 } };

		sortColumnAscending(matrix);
		printMatrix(matrix);

		sortColumnDescending(matrix);
		printMatrix(matrix);
	}

	public static void sortColumnAscending(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		boolean isIrregularMatrix;

		isIrregularMatrix = isIrregularMatrix(matrix);

		int maxLength = matrix[0].length;

		if (isIrregularMatrix) {
			maxLength = findMaxLength(matrix);
			sortIrregularMatrix(matrix);
		}

		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < matrix.length; j++) {

				if (matrix[j].length - 1 < i) {
					continue;
				}

				int minId = j;
				for (int j2 = j + 1; j2 < matrix.length; j2++) {

					if (matrix[j2].length - 1 >= i && matrix[minId][i] > matrix[j2][i]) {
						minId = j2;
					}
				}
				swap(matrix, minId, i, j, i);
			}
		}
	}

	public static void sortColumnDescending(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		boolean isIrregularMatrix;

		isIrregularMatrix = isIrregularMatrix(matrix);

		int maxLength = matrix[0].length;

		if (isIrregularMatrix) {
			maxLength = findMaxLength(matrix);
			sortIrregularMatrix(matrix);
		}

		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < matrix.length; j++) {

				if (matrix[j].length - 1 < i) {
					continue;
				}

				int minId = j;
				for (int j2 = j + 1; j2 < matrix.length; j2++) {

					if (matrix[j2].length - 1 >= i && matrix[minId][i] < matrix[j2][i]) {
						minId = j2;
					}
				}
				swap(matrix, minId, i, j, i);
			}
		}
	}

	public static void swap(int[][] matrix, int ind1, int ind2, int ind3, int ind4) {
		int temp = matrix[ind1][ind2];
		matrix[ind1][ind2] = matrix[ind3][ind4];
		matrix[ind3][ind4] = temp;
	}

	public static boolean exists(int[][] matrix) {
		boolean exists = true;

		if (matrix == null || matrix.length == 0) {
			exists = false;
		}

		return exists;
	}

	public static boolean isIrregularMatrix(int[][] matrix) {
		boolean isIrregularMatrix = false;

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i].length != matrix[0].length) {
				isIrregularMatrix = true;
			}
		}

		return isIrregularMatrix;
	}

	public static int findMaxLength(int[][] matrix) {
		int maxLength = matrix[0].length;

		for (int i = 1; i < matrix.length; i++) {

			if (matrix[i].length > maxLength) {
				maxLength = matrix[i].length;
			}
		}

		return maxLength;
	}

	public static void sortIrregularMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {

			int maxLengthId = i;
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[j].length > matrix[maxLengthId].length) {
					maxLengthId = j;
				}
			}

			int[] temp = matrix[i];
			matrix[i] = matrix[maxLengthId];
			matrix[maxLengthId] = temp;
		}
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
