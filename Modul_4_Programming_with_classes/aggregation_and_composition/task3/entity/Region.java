package by.jonline.module_4.aggregation_and_composition.task3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Region implements Serializable {

	private static final long serialVersionUID = -4698736328600288711L;

	private String name;
	private City regionalCenter;
	private double area;
	private List<District> districts;

	public Region() {
		this("", new City(), 0);
	}

	public Region(String name, City regionalCenter, double area) {
		this.name = name;

		if (regionalCenter != null) {
			this.regionalCenter = regionalCenter;
		} else {
			this.regionalCenter = new City();
		}

		if (area > 0) {
			this.area = area;
		}
		this.districts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getRegionalCenter() {
		return regionalCenter;
	}

	public void setRegionalCenter(City regionalCenter) {
		if (regionalCenter != null) {
			this.regionalCenter = regionalCenter;
		}
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if (area > 0) {
			this.area = area;
		}
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		if (districts != null) {
			this.districts = districts;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((districts == null) ? 0 : districts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regionalCenter == null) ? 0 : regionalCenter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Region other = (Region) obj;

		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
			return false;
		if (!Objects.equals(districts, other.districts))
			return false;
		if (!Objects.equals(name, other.name))
			return false;
		return Objects.deepEquals(regionalCenter, other.regionalCenter);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", regionalCenter=")
				.append(regionalCenter).append(", area=").append(area).append(", districts=").append(districts)
				.append("]");
		return builder.toString();
	}
}