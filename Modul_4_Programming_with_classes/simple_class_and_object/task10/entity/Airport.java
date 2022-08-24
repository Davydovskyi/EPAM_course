package by.jonline.module_4.simple_class_and_object.task10.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airport implements Serializable {

	private static final long serialVersionUID = -6578934779843604722L;

	private List<Airline> airlines;

	public Airport() {
		airlines = new ArrayList<>();
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void addAirline(Airline airline) {
		if (airline != null) {
			airlines.add(airline);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlines == null) ? 0 : airlines.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Airport other = (Airport) obj;

		return Objects.equals(airlines, other.airlines);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [airport=").append(airlines).append("]");
		return builder.toString();
	}
}