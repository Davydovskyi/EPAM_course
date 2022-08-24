package by.jonline.module_4.aggregation_and_composition.task3.main;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task3.entity.City;
import by.jonline.module_4.aggregation_and_composition.task3.entity.Country;
import by.jonline.module_4.aggregation_and_composition.task3.entity.Region;
import by.jonline.module_4.aggregation_and_composition.task3.logic.CountryLogic;
import by.jonline.module_4.aggregation_and_composition.task3.view.CounrtyView;

/**
 * Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные
 * центры.
 */

public class Main {

	public static void main(String[] args) {
		CounrtyView counrtyView = new CounrtyView();
		CountryLogic countryLogic = new CountryLogic();

		City minsk = new City("Минск");
		City brest = new City("Брест");
		City gomel = new City("Гомель");
		City grodno = new City("Гродно");
		City mogilev = new City("Могилев");
		City vitebsk = new City("Витебск");

		Country belarus = new Country("Беларусь", minsk);

		List<Region> regions = new ArrayList<>();
		regions.add(new Region("Минская", minsk, 40202));
		regions.add(new Region("Брестская", brest, 32786));
		regions.add(new Region("Гомельская", gomel, 40372));
		regions.add(new Region("Гродненская", grodno, 25127));
		regions.add(new Region("Могилёвская", mogilev, 29068));
		regions.add(new Region("Витебская", vitebsk, 40051));

		belarus.setRegions(regions);

		counrtyView.printCapital(belarus);
		counrtyView.printValue("Количество областей: ", belarus.getRegions().size());

		double area;
		area = countryLogic.getArea(belarus);
		counrtyView.printValue("Площадь (кв.км): ", area);
		
		List<City> regionalCentres;
		regionalCentres = countryLogic.getRegionalCenters(belarus);
		counrtyView.printRegionCenters(regionalCentres);
	}
}