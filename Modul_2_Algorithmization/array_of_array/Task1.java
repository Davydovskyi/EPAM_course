package by.jonline.module_2.array_of_array;

/**
 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент
 * больше последнего.
 */

public class Task1 {

	public static void main(String[] args) {

		int[][] matrix = { { 12, 5, 7, 23 }, { 12, 45, 67, 34 }, { 3, 4, 8, 34 } };

		printElement(matrix);
	}

	public static void printElement(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}

		for (int i = 1; i < matrix.length; i++) {

			if (matrix[0].length != matrix[i].length) {

				System.out.println("Нерегулярная матрица.");
				return;
			}
		}

		for (int i = 0; i < matrix[0].length; i += 2) {

			if (matrix[0][i] > matrix[matrix.length - 1][i]) {

				for (int j = 0; j < matrix.length; j++) {

					System.out.print(matrix[j][i] + " ");
				}
			}
			System.out.println();
		}
	}
}
