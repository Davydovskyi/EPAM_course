package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 *                          1   1   1  ...  1   1   1 
 *                          2   2   2  ...  2   2   0 
 *                          3   3   3  ...  3   0   0 
 *                         ... ... ... ... ... ... ... 
 *                         n-1 n-1  0  ...  0   0   0  
 *                          n   0   0  ...  0   0   0
 */

public class Task5 {

	public static void main(String[] args) {

		int n = 10;

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
			for (int j = 0; j < matrix[i].length - i; j++) {
				matrix[i][j] = i + 1;
			}
		}

		return matrix;
	}

}
