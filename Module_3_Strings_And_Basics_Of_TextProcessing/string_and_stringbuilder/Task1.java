package by.jonline.module_3.string_and_stringbuilder;

/**
 * Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в
 * нем.
 */

public class Task1 {

	public static void main(String[] args) {

		String text = "   sdf     sdjk       sdf    ";

		int maxCountOfWhitespaces;
		maxCountOfWhitespaces = getMaxCountOfWhitespaces(text);

		System.out.println(maxCountOfWhitespaces);
	}

	public static int getMaxCountOfWhitespaces(String text) {

		if (text == null) {
			return 0;
		}

		int count = 0;

		StringBuilder builder = new StringBuilder(" ");

		while (text.contains(builder)) {
			builder.append(" ");
			count++;
		}
		return count;
	}
}