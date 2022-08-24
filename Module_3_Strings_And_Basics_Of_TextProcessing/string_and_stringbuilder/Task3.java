package by.jonline.module_3.string_and_stringbuilder;

/**
 * Проверить, является ли заданное слово палиндромом.
 */

public class Task3 {

	public static void main(String[] args) {

		String text = "Anna ";

		boolean isPalindrome;
		isPalindrome = checkIfPalindrome(text);

		System.out.println(isPalindrome);
	}

	public static boolean checkIfPalindrome(String text) {

		if (text == null) {
			return false;
		}

		String temp = text.trim();
		StringBuilder builder = new StringBuilder(temp);
		builder.reverse();

		return temp.equalsIgnoreCase(builder.toString());
	}
}