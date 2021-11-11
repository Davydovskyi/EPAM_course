package by.jonline.module_1.linear;

import java.util.Scanner;

/**
 * Найдите значение функции: z = ((a – 3 ) * b / 2) + c.
 */

public class Task1 {

	public static void main(String[] args) {

		double a;
		double b;
		double c;
		double z;

		a = enterFromConsole("a");
		b = enterFromConsole("b");
		c = enterFromConsole("c");

		z = ((a - 3) * b / 2) + c;
		
		System.out.println("z = ((a – 3 ) * b / 2) + c = " + z);
	}

	public static double enterFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(message + " >>");
		while (!scanner.hasNextDouble()) {
			scanner.next();			
		}
		
		return scanner.nextDouble();
	}
}
