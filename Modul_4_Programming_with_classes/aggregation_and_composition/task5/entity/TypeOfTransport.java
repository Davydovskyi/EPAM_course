package by.jonline.module_4.aggregation_and_composition.task5.entity;

public enum TypeOfTransport {

	TRAIN("Поезд"), AIRPLANE("Самолёт"), BUS("Автобус"), LINER("Лайнер"), WITHOUT_TRANSPORT("Без транспорта");

	private String name;

	private TypeOfTransport(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}