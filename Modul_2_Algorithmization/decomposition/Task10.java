package by.jonline.module_2.decomposition;

import java.util.Arrays;

/**
 * Дано натуральное число N. Написать метод(методы) для формирования массива,
 * элементами которого являются цифры числа N.
 */
public class Task10 {

	public static void main(String[] args) {

		int number = 124348;

		if (number < 1) {
			return;
		}

		int[] array;
		array = getArray(number);

		System.out.println(Arrays.toString(array));
	}

	public static int[] getArray(int number) {

		int[] array = new int[String.valueOf(number).length()];

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = number % 10;
			number /= 10;
		}
		return array;
	}
}