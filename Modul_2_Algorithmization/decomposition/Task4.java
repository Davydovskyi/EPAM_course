package by.jonline.module_2.decomposition;

import java.util.Random;

/**
 * На плоскости заданы своими координатами n точек. Написать метод(методы),
 * определяющие, между какими из пар точек самое большое расстояние. Указание.
 * Координаты точек занести в массив.
 */

public class Task4 {

	public static void main(String[] args) {

		int n = 6;

		int[][] arrayXY;
		arrayXY = initArray(n);

		int[] points;
		points = getPoints(arrayXY);

		if (points.length == 0) {
			return;
		}

		System.out.printf("Maximum distance between points [%d, %d] and [%d, %d].", arrayXY[points[0]][0],
				arrayXY[points[0]][1], arrayXY[points[1]][0], arrayXY[points[1]][1]);
	}

	public static int[] getPoints(int[][] array) {

		if (array.length < 2) {
			return new int[0];
		}

		int[] points = new int[2];
		double maxDistance = -1;

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				double distance = getDistance(array[i][0], array[i][1], array[j][0], array[j][1]);
				if (distance > maxDistance) {
					maxDistance = distance;
					points[0] = i;
					points[1] = j;
				}
			}
		}
		return points;
	}

	public static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

	public static int[][] initArray(int n) {

		if (n < 1) {
			return new int[0][0];
		}

		int[][] array = new int[n][2];

		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i][0] = random.nextInt(11);
			array[i][1] = random.nextInt(11);
		}

		return array;
	}
}