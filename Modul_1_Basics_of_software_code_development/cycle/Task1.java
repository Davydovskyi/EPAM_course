package by.jonline.cycle;

import java.util.Scanner;

/**
 * Напишите программу, где пользователь вводит любое целое положительное число.
 * А программа суммирует все числа от 1 до введенного пользователем числа.
 */

public class Task1 {

	public static void main(String[] args) {

		long number;

		long maxNumber = 4294967295L;

		long sum = 0;

		do {
			number = enterFromConsole();

			if (number > maxNumber) {
				System.out.println("The number is too large.");
			}

		} while (number < 1 || number > maxNumber);

		for (long i = 1; i <= number; i++) {
			sum += i;
		}

		System.out.println(sum);

	}

	public static long enterFromConsole() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number >>");
		while (!scanner.hasNextLong()) {
			scanner.next();
		}
		return scanner.nextLong();

	}

}
