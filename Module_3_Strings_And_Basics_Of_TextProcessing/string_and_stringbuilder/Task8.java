package by.jonline.module_3.string_and_stringbuilder;

import java.util.Scanner;

/**
 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и
 * вывести его на экран. Случай, когда самых длинных слов может быть несколько,
 * не обрабатывать.
 */

public class Task8 {

	public static void main(String[] args) {

		String text;
		text = enterFromConsole("Введите слова!");

		String longestWord;
		longestWord = getLongestWord(text);

		System.out.println(longestWord);
	}

	public static String getLongestWord(String text) {

		if (text == null || text.isEmpty()) {
			return "";
		}

		String[] array = text.split("\\s+");

		System.out.println(array.length);

		if (array.length == 0) {
			return "";
		}

		int indexOfLongestWord = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[indexOfLongestWord].length() < array[i].length()) {
				indexOfLongestWord = i;
			}
		}

		return array[indexOfLongestWord];
	}

	public static String enterFromConsole(String message) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(message);

		return scanner.nextLine();
	}
}