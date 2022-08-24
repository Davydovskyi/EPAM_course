package by.jonline.module_4.simple_class_and_object.task10.entity;

import java.io.Serializable;
import java.util.Objects;

public class Airline implements Serializable {

	private static final long serialVersionUID = 3142618875515915556L;

	private String destination;
	private int flightNumber;
	private String aircraftType;
	private Time departureTime;
	private DayOfWeek day;

	public Airline() {
		this("", 0, "", new Time(), DayOfWeek.NOT_SET);
	}

	public Airline(String destination, int flightNumber, String aircraftType, Time departureTime, DayOfWeek day) {
		this.destination = destination;
		if (flightNumber > 0) {
			this.flightNumber = flightNumber;
		}
		this.aircraftType = aircraftType;

		if (departureTime != null) {
			this.departureTime = departureTime;
		} else {
			this.departureTime = new Time();
		}

		if (day != null) {
			this.day = day;
		} else {
			this.day = DayOfWeek.NOT_SET;
		}
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		if (flightNumber > 0) {
			this.flightNumber = flightNumber;
		}
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		if (departureTime != null) {
			this.departureTime = departureTime;
		}
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		if (day != null) {
			this.day = day;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aircraftType == null) ? 0 : aircraftType.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + flightNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Airline other = (Airline) obj;

		if (!Objects.equals(aircraftType, other.aircraftType)) {
			return false;
		}
		if (!Objects.equals(departureTime, other.departureTime)) {
			return false;
		}
		if (!Objects.equals(destination, other.destination)) {
			return false;
		}
		if (flightNumber != other.flightNumber)
			return false;
		return day == other.day;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [destination=").append(destination)
				.append(", flightNumber=").append(flightNumber).append(", aircraftType=").append(aircraftType)
				.append(", departureTime=").append(departureTime).append(", day=").append(day).append("]");
		return builder.toString();
	}
}