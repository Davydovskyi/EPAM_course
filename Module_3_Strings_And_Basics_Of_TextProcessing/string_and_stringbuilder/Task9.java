package by.jonline.module_3.string_and_stringbuilder;

/**
 * Посчитать количество строчных (маленьких) и прописных (больших) букв в
 * введенной строке. Учитывать только английские буквы.
 */

public class Task9 {

	public static void main(String[] args) {

		String text = "sdfASKJH aSFk ";

		int[] result;
		result = getCountOfUpperAndLowercaseLetters(text);

		int countOfLovercaseLetters = result[0];
		int counOfUppercaseLetters = result[1];

		System.out.printf("Строчные буквы: %d%nПрописные буквы: %d", countOfLovercaseLetters, counOfUppercaseLetters);
	}

	public static int[] getCountOfUpperAndLowercaseLetters(String text) {

		if (text == null) {
			return new int[2];
		}

		int[] result = new int[2];

		char[] array;
		array = text.toCharArray();

		for (char c : array) {
			if (c >= 'a' && c <= 'z') {
				result[0]++;
			} else if (c >= 'A' && c <= 'Z') {
				result[1]++;
			}
		}
		return result;
	}
}