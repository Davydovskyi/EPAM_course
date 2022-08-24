package by.jonline.module_3.string_and_stringbuilder;

/**
 * Из заданной строки получить новую, повторив каждый символ дважды.
 */

public class Task6 {

	public static void main(String[] args) {

		String text = "dfgd dfg";

		String newText;
		newText = duplicateEachChar(text);

		System.out.println(newText);
	}

	public static String duplicateEachChar(String text) {

		if (text == null) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		char ch;

		for (int i = 0; i < text.length(); i++) {
			ch = text.charAt(i);
			builder.append(ch).append(ch);
		}

		return builder.toString();
	}
}