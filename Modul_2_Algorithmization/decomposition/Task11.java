package by.jonline.module_2.decomposition;

/**
 * Написать метод(методы), определяющий, в каком из данных двух чисел больше
 * цифр.
 */

public class Task11 {

	public static void main(String[] args) {

		int number1 = 1234;
		int number2 = -4356;

		int length1;
		length1 = getLength(number1);

		int length2;
		length2 = getLength(number2);

		if (length1 > length2) {
			System.out.println(number1 + " contains more digits.");
		} else if (length1 < length2) {
			System.out.println(number2 + " contains more digits.");
		} else {
			System.out.println("The quantity of digits is the same.");
		}
	}

	public static int getLength(int number) {

		int temp = Math.abs(number);

		if (number == 0) {
			return 1;
		}

		int length = 0;

		while (temp > 0) {
			temp /= 10;
			length++;
		}
		return length;
	}
}