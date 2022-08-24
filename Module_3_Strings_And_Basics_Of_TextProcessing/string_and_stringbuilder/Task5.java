package by.jonline.module_3.string_and_stringbuilder;

/**
 * Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */

public class Task5 {

	public static void main(String[] args) {

		String text = "qwkaaaAAsd;f";

		int countOfMatches;
		countOfMatches = getCountOfMatches(text, "a");

		System.out.println(countOfMatches);
	}

	public static int getCountOfMatches(String text, String letter) {

		if (text == null || letter == null) {
			return 0;
		}

		int count = 0;

		String[] array = text.split("");
		for (String string : array) {
			if (string.equalsIgnoreCase(letter)) {
				count++;
			}
		}
		return count;
	}
}