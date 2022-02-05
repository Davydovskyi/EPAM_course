package by.jonline.module_2.one_array;

/**
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые
 * кратны данному К.
 */

public class Task1 {

	public static void main(String[] args) {

		long[] array = new long[] { 2, 45, 67, 23, 4, 87, 5 };

		int k = 5;

		System.out.println("sum = " + sum(array, k));

	}

	public static long sum(long[] array, int k) {

		long sum = 0;

		if (array == null) {
			return sum;
		}

		if (k == 0) {
			System.out.println("\"K\" should't be zero.");
			return sum;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0 && array[i] % k == 0) {
				sum += array[i];
			}
		}

		return sum;
	}

}
