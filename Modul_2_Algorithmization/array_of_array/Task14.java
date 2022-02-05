package by.jonline.module_2.array_of_array;

import java.util.Arrays;
import java.util.Random;

/**
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в
 * каждом столбце число единиц равно номеру столбца.
 */

public class Task14 {

	public static void main(String[] args) {

		int m = 5;
		int n = 4;

		int[][] matrix;
		matrix = createMatrix(m, n);

		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}
	}

	public static int[][] createMatrix(int rows, int columns) {

		if (rows < 0 || columns < 0 || rows < columns) {
			System.out.println("It's not possible to create a matrix.");
			return new int[0][0];
		}

		int[][] matrix = new int[rows][columns];

		Random random = new Random();
		int count;

		for (int i = 0; i < matrix[0].length; i++) {

			count = i + 1;
			while (count > 0) {
				int j = random.nextInt(rows);
				if (matrix[j][i] == 0) {
					matrix[j][i] = 1;
					count--;
				}
			}
		}

		return matrix;
	}
}