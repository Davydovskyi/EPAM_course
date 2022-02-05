package by.jonline.module_2.array_of_array;

import java.util.Arrays;

/**
 * Магическим квадратом порядка n называется квадратная матрица размера n x n,
 * составленная из чисел 1, 2, 3, ..., n² так, что суммы по каждому столбцу,
 * каждой строке и каждой из двух больших диагоналей равны между собой.
 * Построить такой квадрат. Пример магического квадрата порядка 3:
 *                         6 1 8
 *                         7 5 3
 *                         2 9 4
 */                         

public class Task16 {

	public static void main(String[] args) {

		int n = 4;

		int[][] matrix;
		matrix = initMatrix(n);

		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}
	}

	public static int[][] initMatrix(int n) {

		if (n < 3) {
			System.out.println("It's impossible to create a magic square.");
			return new int[0][0];
		}

		int[][] matrix = new int[n][n];

		if (n % 2 == 1) {
			createOddMagicSquare(matrix, n);
		} else if (n % 4 == 0) {
			createDoubleEvenMagicSquare(matrix, n);
		} else {
			createSingleEvenMagicSquare(matrix, n);
		}

		return matrix;
	}

	/**
	 * Квадрат нечётного порядка. Цифру "1" ставим в середине первой строки. Далее
	 * из этой позиции двиг. вверх по диагонали. Соблюдаем три правила. Если на
	 * позиции есть цифра, то ставим непосредственно под пред.
	 */

	public static void createOddMagicSquare(int[][] matrix, int n) {

		int row = 0;
		int column = n / 2;

		int lastRow;
		int lastColumn;

		for (int k = 1; k <= n * n; k++) {

			matrix[row][column] = k;

			lastRow = row;
			lastColumn = column;

			row--;
			column++;

			if (row < 0) {
				row = n - 1;
			}

			if (column > n - 1) {
				column = 0;
			}

			if (matrix[row][column] != 0) {
				row = lastRow + 1;
				column = lastColumn;
			}
		}
	}

	/**
	 * Квадрат порядка одинарной чётности. Делим матрицу на четверти. Для них n = n
	 * / 2 => 4 матрицы нечётного порядка. Верхняя левая заполняется как обычная
	 * нечётная. Элементы в остальных зеркально равный элементам первой + разница.
	 * Определенное количество элементов из верхних четвертей зеркально меняются
	 * местами с элементами из нижних. http://www.1728.org/magicsq3.htm
	 */

	public static void createSingleEvenMagicSquare(int[][] matrix, int n) {

		createOddMagicSquare(matrix, n / 2);
		fillQuarter(matrix, 2, n);
		fillQuarter(matrix, 3, n);
		fillQuarter(matrix, 4, n);

		int countOfShifted = n / 4;

		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < countOfShifted; j++) {

				if (i == countOfShifted) {
					swap(matrix, i, j + 1, n);
					continue;
				}
				swap(matrix, i, j, n);
			}

			for (int j = n - countOfShifted + 1; j < matrix.length; j++) {
				swap(matrix, i, j, n);
			}
		}
	}

	private static void swap(int[][] matrix, int i, int j, int n) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[i + n / 2][j];
		matrix[i + n / 2][j] = temp;
	}

	private static void fillQuarter(int[][] matrix, int quarter, int n) {

		int startRow = 0;
		int endRow = 0;

		int startColumn = 0;
		int endColumn = 0;

		int diffence = (int) Math.pow(n / 2., 2);

		switch (quarter) {
		case 2:
			startRow = n / 2;
			endRow = n;
			startColumn = n / 2;
			endColumn = n;
			break;
		case 3:
			startRow = 0;
			endRow = n / 2;
			startColumn = n / 2;
			endColumn = n;
			diffence *= 2;
			break;
		case 4:
			startRow = n / 2;
			endRow = n;
			startColumn = 0;
			endColumn = n / 2;
			diffence *= 3;
			break;
		default:
			break;
		}

		for (int i = startRow, x = 0; i < endRow; i++, x++) {
			for (int j = startColumn, y = 0; j < endColumn; j++, y++) {
				matrix[i][j] = matrix[x][y] + diffence;
			}
		}
	}

	/**
	 * Квадрат порядка двойной чётности. Матрица делится на подматрицы 4х4. Элементы
	 * на диагоналях подматриц идут в обратном порядке, вне диагонали – по порядку.
	 * (для 4х: 16 2 3 13 – первая строка и т.д.)
	 * https://rep.bntu.by/bitstream/handle/data/62327/Magicheskie_kvadraty.pdf?sequence=1&isAllowed=y
	 * (стр 8-9).
	 */

	public static void createDoubleEvenMagicSquare(int[][] matrix, int n) {

		int temp1 = 1;
		int temp2 = n * n;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i % 4 == j % 4 || (i + j) % 4 == 3) { // На диагонали ли элемент?
					matrix[i][j] = temp2;

				} else {
					matrix[i][j] = temp1;
				}
				temp1++;
				temp2--;
			}
		}
	}
}
