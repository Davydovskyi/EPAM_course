package by.jonline.module_2.one_array;

import java.util.Arrays;

/**
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из
 * него каждый второй элемент (освободившиеся элементы заполнить нулями).
 * Примечание. Дополнительный массив не использовать.
 */

public class Task10 {

	public static void main(String[] args) {

		int n = 11;

		long[] array;
		array = createArray(n);

		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(removeElement(array)));

	}

	public static long[] createArray(int length) {

		if (length < 0) {
			return new long[0];
		}

		long[] array = new long[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = (long) (Math.random() * 20 - 10);
		}

		return array;
	}

	public static long[] removeElement(long[] array) {

		for (int i = 1; i < array.length; i += 2) {

			array[i] = 0;
		}

		for (int i = 2; i < array.length; i += 2) {

			array[i / 2] = array[i];
			array[i] = 0;
		}

		return array;
	}

}
