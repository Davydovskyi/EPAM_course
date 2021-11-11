package by.jonline.cycle;

import java.util.Scanner;

/**
 * Для каждого натурального числа в промежутке от m до n вывести все делители,
 * кроме единицы и самого числа. m и n вводятся с клавиатуры.
 */

public class Task7 {

	public static void main(String[] args) {

		long m = 0;
		long n = 0;

		while (true) {

			if (m <= 0) {
				m = enterFromConsole("m");

			} else if (n <= 0) {
				n = enterFromConsole("n");

			} else {
				break;
			}
		}

		findTheDivisor(m, n);

	}

	public static long enterFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(message + " >>");
		while (!scanner.hasNextLong()) {
			scanner.next();
		}

		return scanner.nextLong();
	}

	public static void findTheDivisor(long m, long n) {

		if (m > n) {

			long temp = m;
			m = n;
			n = temp;
		}

		for (long i = m; i <= n; i++) {

			System.out.print("Divisor(s) of " + i + " : ");

			for (long j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					System.out.print(j + "; ");
				}
			}
			System.out.println();
		}
	}
}
