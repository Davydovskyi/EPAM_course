package by.jonline.module_2.array_sorting;

import java.util.Arrays;

/**
 * Сортировка обменами. Дана последовательность чисел a1 <= a2 <=...<= an
 * Требуется переставить числа в порядке возрастания. Для этого сравниваются два
 * соседних числа ai и ai+1 . Если ai > ai+1 , то делается перестановка. Так
 * продолжается до тех пор, пока все элементы не станут расположены в порядке
 * убывания. Составить алгоритм сортировки, подсчитывая при этом количества
 * перестановок.
 */

public class Task4 {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int countOfShifts;
		countOfShifts = sort(array);

		System.out.println(Arrays.toString(array));
		System.out.println(countOfShifts);

	}

	public static int sort(int[] array) {

		int countOfShifts = 0;

		if (array == null) {
			return countOfShifts;
		}

		boolean sorted = false;
		while (!sorted) {
			sorted = true;

			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] < array[i + 1]) {
					swap(array, i, i + 1);
					sorted = false;
					countOfShifts++;
				}
			}
		}
		return countOfShifts;
	}

	public static void swap(int[] array, int id1, int id2) {
		int temp = array[id1];
		array[id1] = array[id2];
		array[id2] = temp;
	}
}
