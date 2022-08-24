package by.jonline.module_5.task3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Calendar implements Serializable {

	private static final long serialVersionUID = -4530222841102712252L;

	private int year = 2022;
	private List<Day> dayOffs = new ArrayList<>();

	public Calendar() {
	}

	public Calendar(int year) {
		if (year > 0) {
			this.year = year;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		}
	}

	public List<Day> getDayOffs() {
		return dayOffs;
	}

	public void setDayOffs(List<Day> dayOffs) {
		if (dayOffs != null) {
			this.dayOffs = dayOffs;
		}
	}

	public boolean addDayOff(Day day) {
		if (day != null && day.isDayOff()) {
			return dayOffs.add(day);
		}
		return false;
	}

	public boolean deleteDayOff(Day day) {
		return dayOffs.remove(day);
	}

	public class Day implements Serializable {

		private static final long serialVersionUID = -8717025000567807877L;

		private int date = 1;
		private DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
		private Month month = Month.JANUARY;
		private boolean dayOff;

		public Day() {
		}

		public Day(int date, DayOfWeek dayOfWeek, Month month) {

			if (dayOfWeek != null) {
				this.dayOfWeek = dayOfWeek;
			}
			if (month != null) {
				this.month = month;
			}
			if (date > 0 && date <= this.month.getCountOfDay(getYear())) {
				this.date = date;
			}

			if (this.dayOfWeek.isWeekend()) {
				this.dayOff = true;
				addDayOff(this);
			}
		}

		public int getDate() {
			return date;
		}

		public void setDate(int date) {
			if (date > 0 && date <= this.month.getCountOfDay(getYear())) {
				this.date = date;
			}
		}

		public DayOfWeek getDayOfWeek() {
			return dayOfWeek;
		}

		public void setDayOfWeek(DayOfWeek dayOfWeek) {
			if (dayOfWeek != null) {
				this.dayOfWeek = dayOfWeek;
			}
		}

		public Month getMonth() {
			return month;
		}

		public void setMonth(Month month) {
			if (month != null) {
				this.month = month;
			}
		}

		public boolean isDayOff() {
			return dayOff;
		}

		public void setDayOff(boolean dayOff) {
			this.dayOff = dayOff;
			if (dayOff) {
				addDayOff(this);
			} else {
				deleteDayOff(this);
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + date;
			result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
			result = prime * result + (dayOff ? 1231 : 1237);
			result = prime * result + ((month == null) ? 0 : month.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;

			Day other = (Day) obj;

			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (date != other.date)
				return false;
			if (dayOfWeek != other.dayOfWeek)
				return false;
			if (dayOff != other.dayOff)
				return false;
			return month == other.month;
		}

		private Calendar getEnclosingInstance() {
			return Calendar.this;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(getClass().getSimpleName()).append(" [date=").append(date).append(", dayOfWeek=")
					.append(dayOfWeek).append(", month=").append(month).append(", dayOff=").append(dayOff).append("]");
			return builder.toString();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOffs == null) ? 0 : dayOffs.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Calendar other = (Calendar) obj;

		if (dayOffs == null) {
			if (other.dayOffs != null)
				return false;
		} else if (!dayOffs.equals(other.dayOffs))
			return false;
		return year == other.year;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [year=").append(year).append(", dayOffs=").append(dayOffs)
				.append("]");
		return builder.toString();
	}
}