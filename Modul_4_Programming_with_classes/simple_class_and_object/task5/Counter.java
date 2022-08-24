package by.jonline.module_4.simple_class_and_object.task5;

import java.io.Serializable;

/**
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или
 * уменьшать свое значение на единицу в заданном диапазоне. Предусмотрите
 * инициализацию счетчика значениями по умолчанию и произвольными значениями.
 * Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее
 * получить его текущее состояние. Написать код, демонстрирующий все возможности
 * класса.
 */

public class Counter implements Serializable {

	private static final long serialVersionUID = -825984800574900058L;

	private int minValue;
	private int maxValue;
	private int currentValue;

	public Counter() {
		this(0, 10, 0);
	}

	public Counter(int minValue, int maxValue) {
		this(minValue, maxValue, minValue);
	}

	public Counter(int minValue, int maxValue, int currentValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.currentValue = currentValue;

		if (minValue > maxValue) {
			this.maxValue = minValue;
			this.minValue = maxValue;
		}

		if (this.currentValue > this.maxValue) {
			this.currentValue = this.maxValue;
		}
		if (this.currentValue < this.minValue) {
			this.currentValue = this.minValue;
		}
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void increase() {
		currentValue++;

		if (currentValue > maxValue) {
			currentValue = minValue;
		}
	}

	public void decrease() {
		currentValue--;

		if (currentValue < minValue) {
			currentValue = maxValue;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentValue;
		result = prime * result + maxValue;
		result = prime * result + minValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Counter other = (Counter) obj;

		if (currentValue != other.currentValue)
			return false;
		if (maxValue != other.maxValue)
			return false;
		return minValue == other.minValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [minValue=").append(minValue).append(", maxValue=")
				.append(maxValue).append(", currentValue=").append(currentValue).append("]");
		return builder.toString();
	}
}