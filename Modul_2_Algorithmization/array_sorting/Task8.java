package by.jonline.module_2.array_sorting;

/**
 * Даны дроби p1/q1, p2/q2,..., pn/qn ( pi, qi - натуральные). Составить
 * программу, которая приводит эти дроби к общему знаменателю и упорядочивает их
 * в порядке возрастания.
 */

public class Task8 {

	public static void main(String[] args) {

		long[] numenators = { 3, 5, 9, 11, 36 };
		long[] denominators = { 4, 6, 7, 13, 37 };

		long commonDenominator;
		commonDenominator = findCommonDenominator(numenators, denominators);

		if (commonDenominator == 0) {
			return;
		}

		reduceToCommonDenominator(numenators, denominators, commonDenominator);

		shellSort(numenators);

		print(numenators, commonDenominator);
	}

	public static long findCommonDenominator(long[] array1, long[] array2) {

		if (array1 == null || array2 == null || array1.length < array2.length || array1.length < 2
				|| array2.length == 0) {
			return 0;
		}

		if (array2.length == 1) {
			return array2[0];
		}

		long commonDenominator;
		commonDenominator = nok(array2[0], array2[1]);

		for (int i = 2; i < array2.length; i++) {
			if (commonDenominator % array2[i] != 0) {
				commonDenominator = nok(commonDenominator, array2[i]);
			}
		}

		return commonDenominator;
	}

	public static void reduceToCommonDenominator(long[] array1, long[] array2, long commonDenominator) {

		long temp;
		for (int i = 0; i < array2.length; i++) {
			temp = commonDenominator / array2[i];
			array1[i] = array1[i] * temp;
		}

		if (array1.length > array2.length) {
			for (int i = array2.length; i < array1.length; i++) {
				array1[i] = array1[i] * commonDenominator;
			}
		}
	}

	public static long nod(long a, long b) {

		return b == 0 ? a : nod(b, a % b);
	}

	public static long nok(long a, long b) {

		return a / nod(a, b) * b;
	}

	public static void shellSort(long[] array) {

		int d = array.length / 2;

		while (d > 0) {
			for (int i = 0; i < array.length - d; i++) {

				int j = i;
				while (j >= 0 && array[j] > array[j + d]) {
					swap(array, j, j + d);
					j = j - d;
				}
			}
			d = d / 2;
		}
	}

	public static void swap(long[] array, int id1, int id2) {
		long temp = array[id1];
		array[id1] = array[id2];
		array[id2] = temp;
	}

	public static void print(long[] array, long commonDenominator) {
		for (long l : array) {
			System.out.print(l + "/" + commonDenominator + " ");
		}
	}
}