package by.jonline.module_2.array_of_array;

/**
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class Task3 {

	public static void main(String[] args) {

		int k = 3;
		int p = 2;

		int[][] matrix = { { 2, 3 }, { 4, 5, 6, 7 }, { 8, 9 }, { 4, 3, 2, 1 } };

		printRow(matrix, k);
		printColumn(matrix, p);
	}

	public static void printRow(int[][] matrix, int row) {

		if (matrix == null || row < 0 || row > matrix.length - 1) {

			System.out.println("Row doesn't exist.");
			return;
		}

		StringBuilder rowBuilder = new StringBuilder("Row: ");

		for (int i = 0; i < matrix[row].length; i++) {

			rowBuilder.append(matrix[row][i]).append(" ");
		}

		System.out.println(rowBuilder);
	}

	public static void printColumn(int[][] matrix, int column) {

		if (matrix == null || matrix.length == 0 || column < 0) {

			System.out.println("Column doesn't exist.");
			return;
		}

		StringBuilder columnBuilder = new StringBuilder("Column: ");

		for (int i = 0; i < matrix.length; i++) {

			if (matrix[i].length - 1 < column) {
				continue;
			}

			columnBuilder.append(matrix[i][column]).append(" ");
		}

		System.out.println(columnBuilder);
	}
}
