package by.jonline.module_4.simple_class_and_object.task10.main;

import java.util.List;

import by.jonline.module_4.simple_class_and_object.task10.entity.Airline;
import by.jonline.module_4.simple_class_and_object.task10.entity.Airport;
import by.jonline.module_4.simple_class_and_object.task10.entity.DayOfWeek;
import by.jonline.module_4.simple_class_and_object.task10.entity.Time;
import by.jonline.module_4.simple_class_and_object.task10.logic.AirlineLogic;
import by.jonline.module_4.simple_class_and_object.task10.view.AirlineView;

/**
 * Создать класс Airline, спецификация которого приведена ниже. Определить
 * конструкторы, set- и get- методы и метод toString(). Создать второй класс,
 * агрегирующий массив типа Airline, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль. Airline: пункт
 * назначения, номер рейса, тип самолета, время вылета, дни недели. Найти и
 * вывести: a) список рейсов для заданного пункта назначения; b) список рейсов
 * для заданного дня недели; c) список рейсов для заданного дня недели, время
 * вылета для которых больше заданного.
 */

public class Main {

	public static void main(String[] args) {

		Airport airport = new Airport();
		AirlineLogic airlineLogic = new AirlineLogic();
		AirlineView airlineView = new AirlineView();

		airport.addAirline(new Airline("Минск", 345, "Ту-134", new Time(23, 45), DayOfWeek.MONDAY));
		airport.addAirline(new Airline("Москва", 35, "Боинг-777", new Time(2, 14), DayOfWeek.SUNDAY));
		airport.addAirline(new Airline("Осло", 300, "Сухой Суперджет-100", new Time(12, 5), DayOfWeek.MONDAY));
		airport.addAirline(new Airline("Фарго", 5, "Боинг-767", new Time(21, 00), DayOfWeek.THURSDAY));
		airport.addAirline(new Airline("Париж", 47, "Аэробус A310", new Time(1, 45), DayOfWeek.MONDAY));

		List<Airline> airlinesByDestination;
		airlinesByDestination = airlineLogic.getAirlinesByDestination(airport.getAirlines(), "Фарго");

		if (!airlinesByDestination.isEmpty()) {
			airlineView.printAirlines("Список рейсов для заданного пункта назанчения:", airlinesByDestination);
		} else {
			airlineView.printErrorMessage("Рейсы для заданного пункта назначения не найдены.");
		}

		List<Airline> airlinesByDepartureDay;
		airlinesByDepartureDay = airlineLogic.getAirlinesByDepartureDay(airport.getAirlines(), DayOfWeek.MONDAY);

		if (!airlinesByDepartureDay.isEmpty()) {
			airlineView.printAirlines("Список рейсов для заданного дня недели:", airlinesByDepartureDay);
		} else {
			airlineView.printErrorMessage("Рейсы для заданного дня недели не найдены.");
		}

		List<Airline> airlinesByDepartureTime;
		airlinesByDepartureTime = airlineLogic.getAirlinesByDepartureTime(airport.getAirlines(), DayOfWeek.MONDAY,
				new Time(1, 44));

		if (!airlinesByDepartureTime.isEmpty()) {
			airlineView.printAirlines("Список рейсов после заданного времени вылета:", airlinesByDepartureTime);
		} else {
			airlineView.printErrorMessage("Рейсы после заданного времени не найдены.");
		}
	}
}