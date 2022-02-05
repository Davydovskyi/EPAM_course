package by.jonline.module_2.decomposition;

/**
 * Написать метод(методы) для нахождения наибольшего общего делителя четырех
 * натуральных чисел.
 */

public class Task2 {

	public static void main(String[] args) {

		int[] array = { 9, 3, 6, 27 };

		System.out.println(nod(array));
	}

	public static int nod(int[] array) {

		if (array == null) {
			return 0;
		}

		int nod = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] < 1) {
				return 0;
			}
			nod = nod(nod, array[i]);
		}
		return nod;
	}

	private static int nod(int a, int b) {

		return b == 0 ? a : nod(b, a % b);
	}
}