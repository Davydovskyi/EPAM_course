package by.jonline.module_4.aggregation_and_composition.task5.entity;

public enum TypeOfVoucher {

	RELAXATION("Отдых"), EXCURSION("Экскурсия"), TREATMENT("Лечение"), SHOPPING("Шопинг"), CRUISE("Круиз"),
	SPORT("Спорт"), NOT_SET("");

	private String name;

	private TypeOfVoucher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}