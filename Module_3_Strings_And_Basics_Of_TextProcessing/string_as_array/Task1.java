package by.jonline.module_3.string_as_array;

import java.util.Arrays;

/**
 * Дан массив названий переменных в camelCase. Преобразовать названия в
 * snake_case.
 */

public class Task1 {

	public static void main(String[] args) {

		String[] camelCase = { "popNaNa", "handUp", "neckDown", "headLeftAndRight" };

		if (camelCase == null) {
			return;
		}

		String[] shakeCase = new String[camelCase.length];

		for (int i = 0; i < camelCase.length; i++) {
			shakeCase[i] = convertFromCamelCaseToShakeCase(camelCase[i]);
		}

		System.out.println(Arrays.toString(shakeCase));
	}

	public static String convertFromCamelCaseToShakeCase(String name) {

		if (name == null) {
			return "";
		}

		char[] charArray;
		charArray = name.toCharArray();

		StringBuilder builder = new StringBuilder();
		for (char c : charArray) {
			if (Character.isLowerCase(c)) {
				builder.append(c);
			} else {
				builder.append('_').append(c);
			}
		}

		if (builder.length() > 0 && builder.charAt(0) == '_') {
			builder.deleteCharAt(0);
		}

		return builder.toString().toLowerCase();
	}
}