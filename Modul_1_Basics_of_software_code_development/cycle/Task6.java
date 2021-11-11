package by.jonline.module_1.cycle;

/**
 * Вывести на экран соответствий между символами и их численными обозначениями в
 * памяти компьютера.
 */

public class Task6 {

	public static void main(String[] args) {

		for (int i = 33; i <= 126; i++) {

			System.out.println("'" + (char) i + "' - " + i);
		}
	}

}
