package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 *                            1   2   3  ...  n
 *                            n  n-1 n-2 ...  1
 *                            1   2   3  ...  n 
 *                            n  n-1 n-2 ...  1 
 *                           ... ... ... ... ... 
 *                            n  n-1 n-2 ...  1                                
 */

public class Task4 {

	public static void main(String[] args) {

		int n = 6;

		int[][] matrix;

		matrix = createMatrix(n);

		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}

	}

	public static int[][] createMatrix(int length) {

		if (length < 0 || length % 2 != 0) {
			return new int[0][0];
		}

		int[][] matrix = new int[length][length];

		for (int i = 0; i < matrix.length; i++) {

			matrix[0][i] = i + 1;
			matrix[1][length - 1 - i] = i + 1;
		}

		for (int i = 2; i < matrix.length; i++) {

			matrix[i] = matrix[i - 2];
		}
		return matrix;
	}

}
