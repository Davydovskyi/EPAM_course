package by.jonline.module_4.aggregation_and_composition.task3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country implements Serializable {

	private static final long serialVersionUID = 5885601151258931957L;

	private String name;
	private City capital;
	private List<Region> regions;

	public Country() {
		this("", new City());
	}

	public Country(String name, City capital) {
		this.name = name;

		if (capital != null) {
			this.capital = capital;
		} else {
			this.capital = new City();
		}
		this.regions = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		if (capital != null) {
			this.capital = capital;
		}
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		if (regions != null && !regions.isEmpty()) {
			this.regions = regions;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regions == null) ? 0 : regions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Country other = (Country) obj;

		if (!Objects.equals(capital, other.capital))
			return false;
		if (!Objects.equals(name, other.name))
			return false;
		return Objects.equals(regions, other.regions);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", capital=").append(capital)
				.append(", regions=").append(regions).append("]");
		return builder.toString();
	}
}