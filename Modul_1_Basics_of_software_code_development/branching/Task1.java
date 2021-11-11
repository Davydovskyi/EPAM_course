package by.jonline.branching;

/**
 * Даны два угла треугольника (в градусах). Определить, существует ли такой
 * треугольник, и если да, то будет ли он прямоугольным.
 */

public class Task1 {

	public static void main(String[] args) {

		int angleA = 80;
		int angleB = 10;

		if (angleA + angleB < 180 && angleA != 0 && angleB != 0) {

			System.out.print("Треугольник существует ");

			if (angleA == 90 || angleB == 90 || angleA + angleB == 90) {

				System.out.println("и он прямоугольный.");

			} else {

				System.out.println("и он не прямоугольный.");
			}
		} else {

			System.out.println("Треугольник не существует.");
		}

	}

}
