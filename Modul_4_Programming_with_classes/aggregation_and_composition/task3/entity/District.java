package by.jonline.module_4.aggregation_and_composition.task3.entity;

import java.io.Serializable;
import java.util.Objects;

public class District implements Serializable {

	private static final long serialVersionUID = 2877562246301563300L;

	private String name;
	private City districtCenter;

	public District() {
		this("", new City());
	}

	public District(String name, City districtCenter) {
		this.name = name;
		if (districtCenter != null) {
			this.districtCenter = districtCenter;
		} else {
			this.districtCenter = new City();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getDistrictCenter() {
		return districtCenter;
	}

	public void setDistrictCenter(City districtCenter) {
		if (districtCenter != null) {
			this.districtCenter = districtCenter;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((districtCenter == null) ? 0 : districtCenter.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		District other = (District) obj;

		if (!Objects.equals(districtCenter, other.districtCenter)) {
			return false;
		}
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", districtCenter=")
				.append(districtCenter).append("]");
		return builder.toString();
	}
}