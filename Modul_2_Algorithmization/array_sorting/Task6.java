package by.jonline.module_2.array_sorting;

import java.util.Arrays;

/**
 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить
 * его по возрастанию. Делается это следующим образом: сравниваются два соседних
 * элемента ai и ai+1. Если ai <= ai+1, то продвигаются на один элемент вперед.
 * Если ai > ai+1, то производится перестановка и сдвигаются на один элемент
 * назад. Составить алгоритм этой сортировки.
 */

public class Task6 {

	public static void main(String[] args) {

		double[] array = { 0, 1, -2, 3.4, -1.1, 5, 7.9 };

		shellSort(array);

		System.out.println(Arrays.toString(array));
	}

	public static void gnomeSort(double[] array) { // По условию.

		if (array == null) {
			return;
		}

		int i = 0;
		int j = 1;

		while (i < array.length - 1) {
			if (i == -1 || array[i] <= array[i + 1]) {
				i = j;
				j++;
			} else {
				swap(array, i, i + 1);
				i--;
			}
		}
	}

	public static void shellSort(double[] array) { // Cортировка Шелла.

		if (array == null) {
			return;
		}

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

	public static void swap(double[] array, int id1, int id2) {
		double temp = array[id1];
		array[id1] = array[id2];
		array[id2] = temp;
	}
}
