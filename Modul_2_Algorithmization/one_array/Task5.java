package by.jonline.module_2.one_array;

import java.util.Arrays;

/**
 * Даны целые числа а1, а2,..., аn . Вывести на печать только те числа, для
 * которых аi > i.
 */

public class Task5 {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 2, 1, 45, 0, 56 };

		printElement(array);

	}

	public static void printElement(int[] array) {
		
		if (array == null) {
			System.out.println(Arrays.toString(array));
			return;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) {
				System.out.print(array[i] + " ");
			}
		}
	}

}
