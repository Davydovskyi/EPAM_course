package by.jonline.module_1.cycle;

/**
 * Даны два числа. Определить цифры, входящие в запись как первого так и второго
 * числа.
 */

public class Task8 {

	public static void main(String[] args) {

		int number1 = -1241240;
		int number2 = 2347800;

		String result;

		number1 = Math.abs(number1);
		number2 = Math.abs(number2);

		result = findMatches(number1, number2);

		System.out.println("Common number(s): " + result);

	}

	public static String findMatches(int number1, int number2) {

		int tempNumber1 = number1;
		int tempNumber2;

		int remainder1;
		int remainder2;

		StringBuilder resultBuilder = new StringBuilder();

		if ((number1 == 0 || number2 == 0) && containsZero(number1, number2)) {
			return resultBuilder.append("0;").toString();
		}

		while (tempNumber1 > 0) {

			remainder1 = tempNumber1 % 10;
			tempNumber1 /= 10;
			tempNumber2 = number2;

			while (tempNumber2 > 0) {

				remainder2 = tempNumber2 % 10;
				tempNumber2 /= 10;

				if (remainder1 == remainder2) {

					if (resultBuilder.toString().contains(String.valueOf(remainder1))) {
						continue;
					}

					resultBuilder.append(remainder1).append("; ");
				}
			}
		}

		return resultBuilder.toString();
	}

	public static boolean containsZero(int number1, int number2) {
		return String.valueOf(number1).contains("0") && String.valueOf(number2).contains("0");
	}
}
