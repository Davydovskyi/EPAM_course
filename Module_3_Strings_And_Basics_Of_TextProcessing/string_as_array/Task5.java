package by.jonline.module_3.string_as_array;

/**
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
 * заменить на одиночные пробелы. Крайние пробелы в строке удалить.
 */

public class Task5 {

	public static void main(String[] args) {

		String text = "   sd  df fv     ";

		String textWithoutExtraWhitespaces;
		textWithoutExtraWhitespaces = removeExtraWhitespaces(text);

		System.out.println(textWithoutExtraWhitespaces);
	}

	public static String removeExtraWhitespaces(String text) {

		if (text == null || text.isEmpty()) {
			return "";
		}

		StringBuilder builder = new StringBuilder();

		char[] charArray;
		charArray = text.toCharArray();

		int firstIndex = 0;

		while (firstIndex < charArray.length && charArray[firstIndex] == 32) {
			firstIndex++;
		}

		boolean isWhitespace = false;

		for (int i = firstIndex; i < charArray.length; i++) {
			if (charArray[i] == 32) {
				isWhitespace = true;
			} else {
				if (isWhitespace) {
					builder.append(' ');
					isWhitespace = false;
				}
				builder.append(charArray[i]);
			}
		}
		return builder.toString();
	}
}