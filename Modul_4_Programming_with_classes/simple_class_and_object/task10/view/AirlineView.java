package by.jonline.module_4.simple_class_and_object.task10.view;

import java.util.List;

import by.jonline.module_4.simple_class_and_object.task10.entity.Airline;

public class AirlineView {

	public void printAirlines(String message, List<Airline> airlines) {

		System.out.println(message);
		System.out.println("------------------------------------");

		for (Airline airline : airlines) {
			System.out.printf("Куда: %s%nНомер рейса: %d%nТип самолета: %s%nВремя вылета: %s%nДень: %s%n",
					airline.getDestination(), airline.getFlightNumber(), airline.getAircraftType(), airline.getDepartureTime().getTimeString(),
					airline.getDay().getDay());
			System.out.println("------------------------------------");
		}

	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}