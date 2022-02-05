package by.jonline.module_2.decomposition;

/**
 * Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] +
 * D[5]; D[4] + D[5] + D[6]. Пояснение. Составить метод(методы) для вычисления
 * суммы трех последовательно расположенных элементов массива с номерами от k до
 * m.
 */

public class Task8 {

	public static void main(String[] args) {

		int[] array = { 4, 6, 8, 3, 1, 6, 8, 4 };
		int k = 6;

		if (array == null || k < 1 || k > array.length - 2) {
			return;
		}

		long sum;
		sum = getSum(array, k);

		System.out.println(sum);
	}

	public static long getSum(int[] array, int k) {

		long sum = 0;

		for (int i = k - 1; i < k + 2; i++) {
			sum += array[i];
		}
		return sum;
	}
}