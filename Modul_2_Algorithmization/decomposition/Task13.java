package by.jonline.module_2.decomposition;

/**
 * Два простых числа называются «близнецами», если они отличаются друг от друга
 * на 2 (например, 41 и 43). Найти и напечатать все пары «близнецов» из отрезка
 * [n,2n], где n - заданное натуральное число больше 2. Для решения задачи
 * использовать декомпозицию.
 */

public class Task13 {

	public static void main(String[] args) {

		int n = 90;

		if (n < 3) {
			return;
		}

		printTwins(n);
	}

	public static void printTwins(int a) {

		int n = a;
		if (n % 2 == 0) {
			n += 1;
		}

		for (int i = n; i < 2 * a - 2; i = i + 2) {
			if (isPrime(i) && isPrime(i + 2)) {
				System.out.println(i + " " + (i + 2));
			}
		}
	}

	public static boolean isPrime(int number) {

		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}