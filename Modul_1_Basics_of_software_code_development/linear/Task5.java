package by.jonline.module_1.linear;

/**
 * Дано натуральное число Т, которое представляет длительность прошедшего
 * времени в секундах. Вывести данное значение длительности в часах, минутах и
 * секундах в следующей форме: ННч ММмин SSc.
 */

public class Task5 {

	public static void main(String[] args) {

		long fullTime = 100510;
		int hours;
		int minutes;
		int seconds;

		hours = (int) (fullTime / 3600);

		minutes = (int) (fullTime / 60 % 60);

		seconds = (int) (fullTime % 60);

		System.out.printf("%dч %dмин %dс", hours, minutes, seconds);

	}

}
