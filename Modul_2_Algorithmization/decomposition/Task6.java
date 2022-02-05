package by.jonline.module_2.decomposition;

/**
 * Написать метод(методы), проверяющий, являются ли данные три числа взаимно
 * простыми.
 */

public class Task6 {

	public static void main(String[] args) {

		int a = 7;
		int b = 11;
		int c = 3;

		boolean isRelativelyPrime;
		isRelativelyPrime = relativelyPrime(a, b, c);

		System.out.println(isRelativelyPrime);
	}

	public static boolean relativelyPrime(int a, int b, int c) {

		if (a < 2 || b < 2 || c < 2) {
			return false;
		}

		return nod(a, b) == 1 && nod(a, c) == 1 && nod(c, b) == 1;
	}

	public static int nod(int a, int b) {

		return b == 0 ? a : nod(b, a % b);
	}
}