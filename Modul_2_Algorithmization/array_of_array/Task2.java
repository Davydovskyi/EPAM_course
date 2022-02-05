package by.jonline.module_2.array_of_array;

/**
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */

public class Task2 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printElement(matrix);

	}

	public static void printElement(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}

		StringBuilder firstDioganalBuilder = new StringBuilder();
		StringBuilder secondDioganalBuilder = new StringBuilder();

		for (int i = 0; i < matrix.length; i++) {

			if (matrix.length != matrix[i].length) {

				System.out.println("Матрица не квадратная.");
				return;
			}

			firstDioganalBuilder.append(matrix[i][i]).append(" ");
			secondDioganalBuilder.append(matrix[i][matrix.length - 1 - i]).append(" ");
		}

		System.out.println(firstDioganalBuilder.toString() + "\n" + secondDioganalBuilder.toString());
	}
}
