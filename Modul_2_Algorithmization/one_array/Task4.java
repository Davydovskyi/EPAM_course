package by.jonline.module_2.one_array;

import java.util.Arrays;

/**
 * Даны действительные числа а1, а2,..., аn . Поменять местами наибольший и
 * наименьший элементы.
 */

public class Task4 {

	public static void main(String[] args) {

		double[] array = new double[] { 5, 3, 3, 8, 12 };

		swapMaxAndMin(array);

		System.out.println(Arrays.toString(array));

	}

	public static void swapMaxAndMin(double[] array) {

		if (array == null || array.length == 0) {
			return;
		}

		int idMax = 0;
		int idMin = 0;

		for (int i = 1; i < array.length; i++) {

			if (array[i] > array[idMax]) {
				idMax = i;
			} else if (array[i] < array[idMin]) {
				idMin = i;
			}
		}

		double temp = array[idMax];
		array[idMax] = array[idMin];
		array[idMin] = temp;
	}

}
