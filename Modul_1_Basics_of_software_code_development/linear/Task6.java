package by.jonline.linear;

/**
 * Для данной области составить линейную программу, которая печатает true, если
 * точка с координатами (х, у) принадлежит закрашенной области, и false — в
 * противном случае.
 */

public class Task6 {

	public static void main(String[] args) {

		int x = -2;
		int y = 5;

		System.out.println(check(x, y));
	}

	public static boolean check(int x, int y) {

		return (x >= -2 && x <= 2 && y >= 0 && y <= 4) || (x >= -4 && x <= 4 && y >= 0 && y <= -3);

	}

}
