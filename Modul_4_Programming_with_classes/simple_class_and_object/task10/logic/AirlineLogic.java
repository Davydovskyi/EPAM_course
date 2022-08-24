package by.jonline.module_4.simple_class_and_object.task10.logic;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_4.simple_class_and_object.task10.entity.Airline;
import by.jonline.module_4.simple_class_and_object.task10.entity.DayOfWeek;
import by.jonline.module_4.simple_class_and_object.task10.entity.Time;

public class AirlineLogic {

	public List<Airline> getAirlinesByDestination(List<Airline> airlines, String destination) {

		List<Airline> specificAirlines = new ArrayList<>();

		for (Airline airline : airlines) {
			if (airline.getDestination().equalsIgnoreCase(destination)) {
				specificAirlines.add(airline);
			}
		}
		return specificAirlines;
	}

	public List<Airline> getAirlinesByDepartureDay(List<Airline> airlines, DayOfWeek day) {

		List<Airline> specificAirlines = new ArrayList<>();

		for (Airline airline : airlines) {
			if (airline.getDay() == day) {
				specificAirlines.add(airline);
			}
		}
		return specificAirlines;
	}

	public List<Airline> getAirlinesByDepartureTime(List<Airline> airlines, DayOfWeek day, Time time) {

		List<Airline> specificAirlines = new ArrayList<>();

		for (Airline airline : airlines) {
			if (airline.getDay() == day && airline.getDepartureTime().getTimeInMinutes() > time.getTimeInMinutes()) {
				specificAirlines.add(airline);
			}
		}
		return specificAirlines;
	}
}