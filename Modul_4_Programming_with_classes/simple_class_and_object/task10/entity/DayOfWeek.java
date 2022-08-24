package by.jonline.module_4.simple_class_and_object.task10.entity;

public enum DayOfWeek {
	
	MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"), FRIDAY("Пятница"),
	SATURDAY("Суббота"), SUNDAY("Воскресенье"), NOT_SET("");

	private String day;

	private DayOfWeek(String day) {
		this.day = day;
	}

	public String getDay() {
		return day;
	}
}