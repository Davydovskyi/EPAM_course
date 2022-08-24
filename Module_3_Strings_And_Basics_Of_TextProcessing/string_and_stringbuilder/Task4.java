package by.jonline.module_3.string_and_stringbuilder;

/**
 * С помощью функции копирования и операции конкатенации составить из частей
 * слова “информатика” слово “торт”.
 */

public class Task4 {

	public static void main(String[] args) {

		String informatics = "инфоРматика";

		String cake;
		cake = createWordCake(informatics);

		System.out.println(cake);
	}

	public static String createWordCake(String word) {

		if (word == null || !word.equalsIgnoreCase("информатика")) {
			return "";
		}

		String lowerCaseWord = word.toLowerCase();

		String cake = "";
		String t = String.valueOf(lowerCaseWord.charAt(lowerCaseWord.indexOf("т")));
		cake += t;
		cake += lowerCaseWord.substring(3, 5);
		cake += t;

		return cake;
	}
}