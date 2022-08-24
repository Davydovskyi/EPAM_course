package by.jonline.module_3.string_as_array;

/**
 * В строке найти количество чисел.
 */

public class Task4 {

	public static void main(String[] args) {

		String text = "12sad asd 34fds 434sdf 4 4";

		int countOfNumbers;
		countOfNumbers = getCountOfNumbers(text);

		System.out.println(countOfNumbers);
	}

	public static int getCountOfNumbers(String text) {

		if (text == null) {
			return 0;
		}

		char[] charArray;
		charArray = text.toCharArray();

		int count = 0;
		boolean isNumber = false;
		for (char c : charArray) {
			if (Character.isDigit(c)) {
				isNumber = true;
			} else if (!Character.isDigit(c) && isNumber) {
				count++;
				isNumber = false;
			}
		}

		if (isNumber) {
			count++;
		}

		return count;
	}
}