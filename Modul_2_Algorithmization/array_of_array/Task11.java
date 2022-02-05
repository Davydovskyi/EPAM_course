package by.jonline.module_2.array_of_array;

import java.util.Arrays;
import java.util.Random;

/**
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму
 * матрицу и номера строк, в которых число 5 встречается три и более раз.
 */

public class Task11 {

	public static void main(String[] args) {

		int[][] matrix = new int[10][20];

		initMatrix(matrix);

		printMatrix(matrix);

		printRowNumber(matrix);
	}

	public static void initMatrix(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		Random random = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(15);
			}
		}
	}
	
	public static boolean exists(int[][] matrix) {
		boolean exists = true;
		if (matrix == null || matrix.length == 0) {
			exists = false;
		}
		return exists;
	}

	public static void printMatrix(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void printRowNumber(int[][] matrix) {

		if (!exists(matrix)) {
			return;
		}

		int count;

		System.out.print("Row number(s) where \"5\" occurs three or more times: ");

		for (int i = 0; i < matrix.length; i++) {

			count = 0;
			for (int j = 0; j < matrix[i].length; j++) {

				if (matrix[i][j] == 5) {
					count++;
				}
			}

			if (count >= 3) {
				System.out.print(i + 1 + " ");
			}
		}
	}
}
