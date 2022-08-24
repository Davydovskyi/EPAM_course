package by.jonline.module_4.simple_class_and_object.task10.entity;

import java.io.Serializable;

public class Time implements Serializable {

	private static final long serialVersionUID = -8155934534377149646L;

	private int hours;
	private int minutes;

	public Time() {
		this(0, 0);
	}

	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;

		if (isHoursIllegal(hours)) {
			this.hours = 0;
		}

		if (isMinutesIllegal(minutes)) {
			this.minutes = 0;
		}
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;

		if (isHoursIllegal(hours)) {
			this.hours = 0;
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;

		if (isMinutesIllegal(minutes)) {
			this.minutes = 0;
		}
	}

	private boolean isMinutesIllegal(int value) {
		return (value > 59 || value < 0);
	}

	private boolean isHoursIllegal(int value) {
		return (value > 23 || value < 0);
	}

	public int getTimeInMinutes() {
		return getHours() * 60 + getMinutes();
	}

	public String getTimeString() {
		return String.format("%02d:%02d", getHours(), getMinutes());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + minutes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Time other = (Time) obj;

		if (hours != other.hours)
			return false;
		return minutes == other.minutes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [hours=").append(hours).append(", minutes=").append(minutes)
				.append("]");
		return builder.toString();
	}
}