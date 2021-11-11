package by.jonline.cycle;

/**
 * Составить программу нахождения произведения квадратов первых двухсот чисел.
 */

public class Task4 {

	public static void main(String[] args) {

		long result = 1;
		int amountNumbers = 0;

		while (result < Long.MAX_VALUE) {

			amountNumbers++;
			result *= Math.pow(amountNumbers, 2);

			System.out.println(amountNumbers + " : " + result);

		}

		System.out.printf("Используя для решения примитивные типы данных, переполнение наступает на числе %d.",
				amountNumbers);

	}

}
