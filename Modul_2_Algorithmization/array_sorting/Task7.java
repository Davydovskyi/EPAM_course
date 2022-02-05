package by.jonline.module_2.array_sorting;

/**
 * Пусть даны две неубывающие последовательности действительных чисел a1 <= a2
 * <=...<= an и b1 <= b2 <=...<= bm. Требуется указать те места, на которые
 * нужно вставлять элементы последовательности b1 <= b2 <=...<= bm в первую
 * последовательность так, чтобы новая последовательность оставалась
 * возрастающей.
 */

public class Task7 {

	public static void main(String[] args) {

		double[] array1 = { -1, 0, 3, 6.5, 6.7, 8 };
		double[] array2 = { -10, -3, 0.4, 3, 6, 9 };

		insertElement(array1, array2);
	}

	public static void insertElement(double[] array1, double[] array2) {

		if (array1 == null || array2 == null || array1.length == 0) {
			return;
		}

		for (int i = array2.length - 1; i >= 0; i--) {
			int index = binarySearch(array1, array2[i]);

			if (index == array1.length) {
				System.out.println("Element " + array2[i] + " needs to be inserted into position " + (index - 1));
			} else {
				System.out.println("Element " + array2[i] + " needs to be inserted into position " + index);
			}
		}
	}

	public static int binarySearch(double[] array, double elementToSearch) {

		int index = 0;
		int firstIndex = 0;
		int lastIndex = array.length - 1;

		while (firstIndex <= lastIndex) {
			int middleIndex = (firstIndex + lastIndex) / 2;

			if (array[middleIndex] < elementToSearch) {
				firstIndex = middleIndex + 1;
				index = firstIndex;
			} else if (array[middleIndex] > elementToSearch) {
				lastIndex = middleIndex - 1;
				index = middleIndex;
			} else if (array[middleIndex] == elementToSearch) {
				return middleIndex;
			}
		}
		return index;
	}
}