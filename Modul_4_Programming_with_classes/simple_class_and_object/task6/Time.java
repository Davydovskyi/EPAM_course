package by.jonline.module_4.simple_class_and_object.task6;

import java.io.Serializable;

/**
 * Составьте описание класса для представления времени. Предусмотрте возможности
 * установки времени и изменения его отдельных полей (час, минута, секунда) с
 * проверкой допустимости вводимых значений. В случае недопустимых значений
 * полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд.
 */

public class Time implements Serializable {

	private static final long serialVersionUID = -5547606750233527815L;

	public static final String HOUR = "hour";
	public static final String MINUTE = "minute";
	public static final String SECOND = "second";

	private int hours;
	private int minutes;
	private int seconds;

	public Time() {
		this(0, 0, 0);
	}

	public Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;

		if (isHoursIllegal(hours)) {
			this.hours = 0;
		}

		if (isMinOrSecIllegal(minutes)) {
			this.minutes = 0;
		}

		if (isMinOrSecIllegal(seconds)) {
			this.seconds = 0;
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

		if (isMinOrSecIllegal(minutes)) {
			this.minutes = 0;
		}
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;

		if (isMinOrSecIllegal(seconds)) {
			this.seconds = 0;
		}
	}

	public void add(String field, int amount) {

		if (field.equals(HOUR)) {
			setHours(((amount + getHours()) % 24 + 24) % 24);
		}

		if (field.equals(MINUTE)) {
			addHoursAndMinutes(HOUR, amount);
			setMinutes(((amount + getMinutes()) % 60 + 60) % 60);
		}

		if (field.equals(SECOND)) {
			addHoursAndMinutes(MINUTE, amount);
			setSeconds(((amount + getSeconds()) % 60 + 60) % 60);
		}
	}

	private void addHoursAndMinutes(String field, int amount) {

		int value = field.equals(HOUR) ? getMinutes() : getSeconds();

		if (amount < 0) {
			if (amount % 60 + value < 0) {
				add(field, (amount + value) / 60 - 1);
			} else {
				add(field, amount / 60);
			}
		} else {
			add(field, (amount + value) / 60);
		}
	}

	public String getTimeString() {
		return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
	}

	private boolean isMinOrSecIllegal(int value) {
		return (value > 59 || value < 0);
	}

	private boolean isHoursIllegal(int value) {
		return (value > 23 || value < 0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + minutes;
		result = prime * result + seconds;
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
		if (minutes != other.minutes)
			return false;
		return seconds == other.seconds;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [hours=").append(hours).append(", minutes=").append(minutes)
				.append(", seconds=").append(seconds).append("]");
		return builder.toString();
	}
}