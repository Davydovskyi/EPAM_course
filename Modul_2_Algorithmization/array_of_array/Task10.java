package by.jonline.module_2.array_of_array;

/**
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class Task10 {

	public static void main(String[] args) {

		double[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, -9 } };

		findPosElementOnMainDioganal(matrix);
	}

	public static void findPosElementOnMainDioganal(double[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			
			if (matrix.length != matrix[i].length) {
				return;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			
			if (matrix[i][i] > 0) {
				System.out.print(matrix[i][i] + " ");
			}
		}
	}
}
