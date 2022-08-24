package by.jonline.module_4.aggregation_and_composition.task3.view;

import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task3.entity.City;
import by.jonline.module_4.aggregation_and_composition.task3.entity.Country;

public class CounrtyView {

	public void printCapital(Country country) {
		System.out.println("Столица: " + country.getCapital().getName());
	}

	public void printValue(String message, double value) {
		System.out.println(message + value);
	}

	public void printValue(String message, int value) {
		System.out.println(message + value);
	}

	public void printRegionCenters(List<City> cities) {
		StringBuilder builder = new StringBuilder();
		System.out.println("Областные центры: ");
		for (City city : cities) {
			builder.append(city.getName()).append(", ");
		}
		builder.setCharAt(builder.length() - 2, '.');
		System.out.println(builder.toString());
	}
}