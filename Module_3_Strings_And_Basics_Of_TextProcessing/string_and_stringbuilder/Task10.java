package by.jonline.module_3.string_and_stringbuilder;

/**
 * Строка X состоит из нескольких предложений, каждое из которых кончается
 * точкой, восклицательным или вопросительным знаком. Определить количество
 * предложений в строке X.
 */

public class Task10 {

	public static void main(String[] args) {

		String text = "   Sdfkl-sdf!? jkas sa 56 s43df....! Ljske; fuh--iwue \\ 112839? ";

		int countOfSentences;
		countOfSentences = getCountOfSentences(text);

		System.out.println(countOfSentences);
	}

	public static int getCountOfSentences(String text) {

		if (text == null) {
			return 0;
		}

		String[] array = text.trim().split("[.!?]+");

		return array.length;
	}
}