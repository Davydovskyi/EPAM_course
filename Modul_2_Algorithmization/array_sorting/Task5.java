package by.jonline.module_2.array_sorting;

import java.util.Arrays;

/**
 * Сортировка вставками. Дана последовательность чисел a1,a2,..., an Требуется
 * переставить числа в порядке возрастания. Делается это следующим образом.
 * Пусть a1, a2,..., ai - упорядоченная последовательность, т. е. a1 <= a2
 * <=...<= ai. Берется следующее число ai+1 и вставляется в последовательность
 * так, чтобы новая последовательность была тоже возрастающей. Процесс
 * производится до тех пор, пока все элементы от i+1 до n не будут перебраны.
 * Примечание. Место помещения очередного элемента в отсортированную часть
 * производить с помощью двоичного поиска. Двоичный поиск оформить в виде
 * отдельной функции.
 */

public class Task5 {

	public static void main(String[] args) {

		int[] array = { 18, 16, 6, 19, 4, 0, 3, 6 };

		insertionSort(array);

		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort(int[] array) {

		if (array == null) {
			return;
		}

		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int index = binarySearch(array, i, i - 1);
			for (int j = i; j > index; j--) {
				array[j] = array[j - 1];
			}
			array[index] = current;
		}
	}

	public static int binarySearch(int[] array, int elementToSearch, int lastSortedIndex) {

		int firstIndex = 0;
		int lastIndex = lastSortedIndex;
		int index = 0;

		while (firstIndex <= lastIndex) {

			int middleIndex = (firstIndex + lastIndex) / 2;

			if (array[middleIndex] < array[elementToSearch]) {
				firstIndex = middleIndex + 1;
				index = firstIndex;
			} else if (array[middleIndex] > array[elementToSearch]) {
				lastIndex = middleIndex - 1;
				index = middleIndex;
			} else if (array[middleIndex] == array[elementToSearch]) {
				return middleIndex;
			}
		}
		return index;
	}
}
