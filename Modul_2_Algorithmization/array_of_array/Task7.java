package by.jonline.module_2.array_of_array;

/**
 * Сформировать квадратную матрицу порядка N по правилу: A[i, j] = sin((i^2 -
 * j^2) / N) и подсчитать количество положительных элементов в ней.
 */

public class Task7 {

	public static void main(String[] args) {

		int n = 6;

		int countOfPositiveNumber = 0;

		double[][] matrix;
		matrix = createMatrix(n);

		for (double[] array : matrix) {
			for (double element : array) {
				if (element > 0) {
					countOfPositiveNumber++;
				}
			}
		}

		System.out.println(countOfPositiveNumber);

	}

	public static double[][] createMatrix(int length) {

		if (length < 0) {
			return new double[0][0];
		}

		double[][] matrix = new double[length][length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / length);
			}
		}

		return matrix;
	}

}
