package by.jonline.module_3.string_and_stringbuilder;

import java.util.Scanner;

/**
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все
 * пробелы. Например, если было введено "abc cde def", то должно быть выведено
 * "abcdef".
 */

public class Task7 {

	public static void main(String[] args) {

		String text;
		text = enterFromConsole("Введите строку!");

		String newText;
		newText = removeDuplicateChars(text);

		System.out.println(newText);
	}

	public static String removeDuplicateChars(String text) {

		if (text == null) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		for (String s : text.split("")) {
			if (builder.indexOf(s) > -1 || s.equals(" ")) {
				continue;
			}
			builder.append(s);
		}

		return builder.toString();
	}

	public static String enterFromConsole(String message) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(message);

		return scanner.nextLine();
	}
}