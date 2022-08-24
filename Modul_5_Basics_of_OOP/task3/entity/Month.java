package by.jonline.module_5.task3.entity;

public enum Month {

	JANUARY(31), FEBRUARY(28) {
		@Override
		public int getCountOfDay(int year) {
			if (year > 1583) {
				if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
					return 29;
				}
			}
			return 28;
		}
	},
	MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30),
	DECEMBER(31);

	private int countOfDay;

	private Month(int countOfDay) {
		this.countOfDay = countOfDay;
	}

	public int getCountOfDay(int year) {
		return countOfDay;
	}
}