package by.jonline.module_2.decomposition;

/**
 * Написать метод(методы) для нахождения наибольшего общего делителя и
 * наименьшего общего кратного двух натуральных чисел: HOK(A, B) = (A * B) /
 * НОД(A, B).
 */

public class Task1 {

	public static void main(String[] args) {

		int a = 9;
		int b = 9;

		if (a < 1 || b < 1) {
			return;
		}

		System.out.println(nok(a, b));
	}

	public static int nod(int a, int b) {

		return b == 0 ? a : nod(b, a % b);
	}

	public static int nok(int a, int b) {

		return a / nod(a, b) * b;
	}
}