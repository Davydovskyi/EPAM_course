package by.jonline.module_4.aggregation_and_composition.task5.entity;

public enum FoodType {

	RO("Без питания"), BB("Только завтрак"), HB("Полупансион"), FB("Полный пансион"), AI("Всё включено"),
	UAI("Ультра всё включено"), NOT_SET("");

	private String name;

	private FoodType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}