package by.jonline.module_2.decomposition;

import java.util.Arrays;
import java.util.Random;

/**
 * Составить программу, которая в массиве A[N] находит второе по величине число
 * (вывести на печать число, которое меньше максимального элемента массива, но
 * больше всех других элементов).
 */

public class Task5 {

	public static void main(String[] args) {

		int n = 10;

		int[] array;
		array = initArray(n);

		if (array.length < 2) {
			return;
		}

		int secondMaxValue;
		secondMaxValue = getSecondMaxValue(array);

		System.out.println(Arrays.toString(array));

		if (secondMaxValue == Integer.MIN_VALUE) {
			return;
		}
		System.out.println(secondMaxValue);
	}

	public static int getSecondMaxValue(int[] array) {

		int maxValue = Integer.MIN_VALUE;
		int secondMaxValue = maxValue;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue) {
				secondMaxValue = maxValue;
				maxValue = array[i];
			} else if (array[i] > secondMaxValue && array[i] != maxValue) {
				secondMaxValue = array[i];
			}
		}

		return secondMaxValue;
	}

	public static int[] initArray(int n) {

		if (n < 1) {
			return new int[0];
		}

		int[] array = new int[n];

		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}

		return array;
	}
}