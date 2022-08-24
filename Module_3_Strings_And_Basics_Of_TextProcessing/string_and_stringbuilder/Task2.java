package by.jonline.module_3.string_and_stringbuilder;

/**
 * В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Task2 {

	public static void main(String[] args) {

		String text = "a a aasd a aasd";

		String convertedText;
		convertedText = insertChar(text, 'a', 'b');

		System.out.println(convertedText);
	}

	public static String insertChar(String text, char after, char ch) {

		if (text == null) {
			return text;
		}
		
		String temp = String.valueOf(after) + String.valueOf(ch);

		return text.replace(String.valueOf(after), temp);
	}
}