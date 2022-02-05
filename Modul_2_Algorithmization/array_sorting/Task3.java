package by.jonline.module_2.array_sorting;

import java.util.Arrays;

/**
 * Сортировка выбором. Дана последовательность чисел a1 <= a2 <=...<= an
 * Требуется переставить элементы так, чтобы они были расположены по убыванию.
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и
 * ставится на первое место, а первый - на место наибольшего. Затем, начиная со
 * второго, эта процедура повторяется. Написать алгоритм сортировки выбором
 */

public class Task3 {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 5, 5, 8, 10 };

		selectionSort(array);

		System.out.println(Arrays.toString(array));
	}

	public static void selectionSort(int[] array) {

		if (array == null) {
			return;
		}

		for (int i = 0; i < array.length; i++) {
			int maxId = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[maxId]) {
					maxId = j;
				}
			}
			swap(array, maxId, i);
		}
	}

	public static void swap(int[] array, int id1, int id2) {
		int temp = array[id1];
		array[id1] = array[id2];
		array[id2] = temp;
	}

//	public static void sort(int[] array) {
//
//		if (array == null) {
//			return;
//		}
//
//		for (int i = 0; i < array.length / 2; i++) {
//			int temp = array[i];
//			array[i] = array[array.length - 1 - i];
//			array[array.length - 1 - i] = temp;
//		}
//	}
}
