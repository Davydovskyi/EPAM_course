package by.jonline.module_4.aggregation_and_composition.task3.logic;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task3.entity.City;
import by.jonline.module_4.aggregation_and_composition.task3.entity.Country;
import by.jonline.module_4.aggregation_and_composition.task3.entity.Region;

public class CountryLogic {

	public double getArea(Country country) {
		double area = 0;

		if (country == null) {
			return area;
		}

		List<Region> regions = country.getRegions();

		for (Region region : regions) {
			area += region.getArea();
		}

		return area;
	}

	public List<City> getRegionalCenters(Country country) {
		List<City> cities = new ArrayList<>();

		if (country == null) {
			return cities;
		}

		List<Region> regions = country.getRegions();
		for (Region region : regions) {
			cities.add(region.getRegionalCenter());
		}
		return cities;
	}
}