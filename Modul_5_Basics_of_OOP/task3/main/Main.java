package by.jonline.module_5.task3.main;

import by.jonline.module_5.task3.entity.Calendar;
import by.jonline.module_5.task3.entity.Calendar.Day;
import by.jonline.module_5.task3.entity.DayOfWeek;
import by.jonline.module_5.task3.entity.Month;

/**
 * Создать класс Календарь с внутренним классом, с помощью объектов которого
 * можно хранить информацию о выходных и праздничных днях.
 */

public class Main {

	public static void main(String[] args) {
		Calendar calendar2023 = new Calendar(2023);
		Calendar.Day day1 = calendar2023.new Day(23, DayOfWeek.FRIDAY, Month.FEBRUARY);
		Day day2 = calendar2023.new Day(12, DayOfWeek.SUNDAY, Month.JULY);

		day1.setDayOff(true);

		System.out.println(day1);
		System.out.println(day2);

		System.out.println(calendar2023);
	}
}