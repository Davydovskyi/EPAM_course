package by.jonline.module_2.array_of_array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * В числовой матрице поменять местами два столбца любых столбца, т. е. все
 * элементы одного столбца поставить на соответствующие им позиции другого, а
 * его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.
 */

public class Task8 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int columnOne;
		int columnTwo;

		columnOne = enterFromConsole("one");
		columnTwo = enterFromConsole("two");

		swapColumn(matrix, columnOne, columnTwo);

		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}

	}

	public static void swapColumn(int[][] matrix, int columnOne, int columnTwo) {

		if (matrix == null || matrix.length == 0) {

			System.out.println("Matrix doesn't exist.");
			return;
		}

		if (columnOne <= 0 || columnTwo <= 0) {

			System.out.println("Colums don't exist.");
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			if (columnOne > matrix[i].length || columnTwo > matrix[i].length) {

				System.out.println("It's not possible to swap columns");
				return;
			}
		}

		for (int i = 0; i < matrix.length; i++) {

			int temp = matrix[i][columnOne - 1];
			matrix[i][columnOne - 1] = matrix[i][columnTwo - 1];
			matrix[i][columnTwo - 1] = temp;
		}

	}

	public static int enterFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter column number " + message);
		while (!scanner.hasNextInt()) {
			scanner.next();
		}

		return scanner.nextInt();
	}

}
