package by.jonline.module_3.string_as_array;

/**
 * Замените в строке все вхождения 'word' на 'letter'.
 */

public class Task2 {

	public static void main(String[] args) {

		String text = "sd wo wordrdword Word";

		String newText;
		newText = replaceWord(text, "word", "letter");

		System.out.println(newText);
	}

	public static String replaceWord(String text, String oldWord, String newWord) {

		if (text == null) {
			return "";
		}

		if (oldWord == null || oldWord.isEmpty() || newWord == null) {
			return text;
		}

		StringBuilder builder = new StringBuilder();

		char[] charArray;
		charArray = text.toCharArray();

		boolean flag;
		int i = 0;
		while (i < charArray.length) {

			flag = checkIfMatches(charArray, i, oldWord);

			if (flag) {
				builder.append(newWord);
				i += oldWord.length();
			} else {
				builder.append(charArray[i]);
				i++;
			}
		}
		return builder.toString();
	}

	private static boolean checkIfMatches(char[] array, int index, String word) {

		boolean flag = false;

		if (array[index] == word.charAt(0)) {

			flag = true;

			int j = 1;
			while (j < word.length()) {
				if (index + j >= array.length || word.charAt(j) != array[index + j]) {
					return false;
				}
				j++;
			}
		}
		return flag;
	}
}