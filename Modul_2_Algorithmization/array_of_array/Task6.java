package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 *                          1   1   1  ...  1   1   1                           
 *                          0   1   1  ...  1   1   0                           
 *                          0   0   1  ...  1   0   0                           
 *                         ... ... ... ... ... ... ...                          
 *                          0   1   1  ...  1   1   0                           
 *                          1   1   1  ...  1   1   1 
 */

public class Task6 {

	public static void main(String[] args) {

		int n = 4;

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
			if (i < matrix.length / 2) {
				for (int j = i; j < matrix.length - i; j++) {
					matrix[i][j] = 1;
				}
			} else {
				matrix[i] = matrix[matrix.length - 1 - i];
			}

		}

		return matrix;

	}

}
