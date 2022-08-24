package by.jonline.module_5.task3.entity;

public enum DayOfWeek {

	MONDAY(false), TUESDAY(false), WEDNESDAY(false), THURSDAY(false), FRIDAY(false), SATURDAY(true), SUNDAY(true);

	private boolean isWeekend;

	private DayOfWeek(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	public boolean isWeekend() {
		return isWeekend;
	}
}