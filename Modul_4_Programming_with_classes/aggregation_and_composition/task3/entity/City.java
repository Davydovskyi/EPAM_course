package by.jonline.module_4.aggregation_and_composition.task3.entity;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {

	private static final long serialVersionUID = -6254217677976885292L;

	private String name;

	public City() {
		this("");
	}

	public City(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		City other = (City) obj;

		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append("]");
		return builder.toString();
	}
}