package by.jonline.module_2.one_array;

/**
 * Даны действительные числа а1, а2,..., а2n. Найти max(a1 + a2n, a2 + a2n-1,
 * ..... , an + an+1).
 */

public class Task7 {

	public static void main(String[] args) {

		int n = 4;

		double[] array;
		array = createArray(n);

		System.out.println(findMaxSum(array));

	}

	public static double[] createArray(int number) {

		if (number < 0) {
			return new double[0];
		}

		double[] array = new double[2 * number];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * 20 - 10;
		}

		return array;
	}

	public static double findMaxSum(double[] array) {

		if (array.length == 0) {

			System.out.println("Maximum sum not found!");
			return 0;
		}

		double maxSum = array[0] + array[array.length - 1];

		for (int i = 1; i < array.length / 2; i++) {

			double tempSum = array[i] + array[array.length - 1 - i];

			if (tempSum > maxSum) {
				maxSum = tempSum;
			}
		}

		return maxSum;
	}

}
