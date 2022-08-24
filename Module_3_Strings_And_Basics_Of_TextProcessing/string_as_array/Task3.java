package by.jonline.module_3.string_as_array;

/**
 * В строке найти количество цифр.
 */

public class Task3 {

	public static void main(String[] args) {

		String text = "0f1sd23sdf45678akld9asd";

		int countOfDigits;
		countOfDigits = getCountOfDigits(text);

		System.out.println(countOfDigits);
	}

	public static int getCountOfDigits(String text) {

		if (text == null) {
			return 0;
		}

		char[] charArray;
		charArray = text.toCharArray();

		int count = 0;

		for (char c : charArray) {
			if (c >= 48 && c <= 57) {
				count++;
			}
		}
		return count;
	}
}