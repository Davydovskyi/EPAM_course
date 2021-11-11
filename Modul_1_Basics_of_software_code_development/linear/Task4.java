package by.jonline.linear;

/**
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и
 * целой частях). Поменять местами дробную и целую части числа и вывести
 * полученное значение числа.
 */

public class Task4 {

	public static void main(String[] args) {

		double fullNumber = 125.067;
		double numberAfterDot;
		double numberBeforeDot;
		double result;

		numberAfterDot = (int) fullNumber / 1000.0;

		numberBeforeDot = fullNumber * 1000 % 1000;

		result = numberBeforeDot + numberAfterDot;

		System.out.println(result);

	}

}
